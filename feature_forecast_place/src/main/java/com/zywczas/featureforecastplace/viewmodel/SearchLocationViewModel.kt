package com.zywczas.featureforecastplace.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.viewModelScope
import com.zywczas.commonutil.BaseViewModel
import com.zywczas.commonutil.Constants
import com.zywczas.commonutil.R
import com.zywczas.commonutil.Resource
import com.zywczas.commonutil.StringProvider
import com.zywczas.commonutil.logD
import com.zywczas.featureforecastplace.domain.Location
import com.zywczas.networkplaces.params.LocationsParams
import com.zywczas.networkplaces.usecase.GetLocationsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

internal class SearchLocationViewModel(
    private val stringProvider: StringProvider,
    private val getLocationsUseCase: GetLocationsUseCase
) : BaseViewModel() {

    var searchText by mutableStateOf(TextFieldValue())
        private set

    var locations by mutableStateOf<List<Location>>(emptyList())
        private set

    private val searchQueryMutable = MutableSharedFlow<String>()
    private val searchQueryFlow: SharedFlow<String> = searchQueryMutable

    fun init() {
        subscribeToSearchQuery()
    }

    fun onSearchTextChanged(textFieldValue: TextFieldValue) {
        searchText = textFieldValue
        viewModelScope.launch(Dispatchers.IO) {
            searchQueryMutable.emit(textFieldValue.text)
        }
    }

    @OptIn(FlowPreview::class)
    private fun subscribeToSearchQuery() {
        searchQueryFlow
            .onEach { logD(it) }
            .debounce(Constants.DEBOUNCE)
            .distinctUntilChanged()
            .onEach(::getPlaces)
            .catch { cause ->
                showError(stringProvider.getString(R.string.error_general))
                logD(cause)
            }
            .flowOn(Dispatchers.IO)
            .launchIn(viewModelScope)
    }

    private suspend fun getPlaces(placeName: String) {
        val newQuery = placeName.trim()
        if (newQuery.isNotBlank()) {
            when (val result = getLocationsUseCase.get(LocationsParams(placeName = newQuery))) {
                is Resource.Success -> locations = result.data.map { it.toDomain() }
                is Resource.Error -> showError(stringProvider.getString(result.message))
            }
        } else {
            locations = emptyList()
        }
    }
}
