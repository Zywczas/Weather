package com.zywczas.featureforecastplace.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.viewModelScope
import com.zywczas.commonutils.BaseViewModel
import com.zywczas.commonutils.Constants
import com.zywczas.commonutils.RegexExps
import com.zywczas.commonutils.Resource
import com.zywczas.commonutils.logD
import com.zywczas.featureforecastplace.domain.SearchListItem
import com.zywczas.featureforecastplace.domain.toDomain
import com.zywczas.networkplaces.params.LocationsParams
import com.zywczas.networkplaces.usecase.GetNetworkLocationsUseCase
import com.zywczas.storehistory.usecase.GetLocationsHistoryUseCase
import com.zywczas.weather.resources.commonutils.Res
import com.zywczas.weather.resources.commonutils.error_general
import com.zywczas.weather.resources.commonutils.recent_searches_title
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.IO
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.getString

internal class SearchLocationViewModel(
    private val getNetworkLocationsUseCase: GetNetworkLocationsUseCase,
    private val getLocationsHistoryUseCase: GetLocationsHistoryUseCase
) : BaseViewModel() {

    private val cityNamePattern: Regex = Regex(RegexExps.INPUT_CITY_TYPING)

    var searchText by mutableStateOf(TextFieldValue())
        private set

    var locations by mutableStateOf<List<SearchListItem>>(emptyList())
        private set

    private val searchQueryMutable = MutableSharedFlow<String>(extraBufferCapacity = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)
    private val searchQueryFlow: SharedFlow<String> = searchQueryMutable

    fun init() {
        viewModelScope.launch(Dispatchers.IO) {
            getHistoryLocations()
        }
        subscribeToSearchQuery()
    }

    fun onSearchTextChanged(textFieldValue: TextFieldValue) {
        if (cityNamePattern.matches(textFieldValue.text)) {
            searchText = textFieldValue
            searchQueryMutable.tryEmit(textFieldValue.text)
        }
    }

    @OptIn(FlowPreview::class)
    private fun subscribeToSearchQuery() {
        searchQueryFlow
            .debounce(Constants.DEBOUNCE)
            .map { it.trim() }
            .distinctUntilChanged()
            .onEach(::getPlaces)
            .catch { cause ->
                showError(getString(Res.string.error_general))
                logD(cause)
            }
            .flowOn(Dispatchers.IO)
            .launchIn(viewModelScope)
    }

    private suspend fun getPlaces(placeName: String) {
        val newQuery = placeName.trim()
        if (newQuery.isNotBlank()) {
            when (val result = getNetworkLocationsUseCase.get(LocationsParams(placeName = newQuery))) {
                is Resource.Success -> locations = result.data.map { it.toDomain() }
                is Resource.Error -> showError(getString(result.message))
            }
        } else {
            getHistoryLocations()
        }
    }

    private suspend fun getHistoryLocations() {
        val historyLocations = getLocationsHistoryUseCase.get().map { it.toDomain() }
        if (historyLocations.isNotEmpty()) {
            locations = mutableListOf<SearchListItem>(SearchListItem.Header(getString(Res.string.recent_searches_title))).apply {
                addAll(historyLocations)
            }
        }
    }
}
