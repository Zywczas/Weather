package com.zywczas.commonutil

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
//todo update to KMM
abstract class BaseViewModel : ViewModel() {

    private val _announcement = MutableSharedFlow<String>()
    val announcement: SharedFlow<String> = _announcement

    suspend fun showError(msg: String) {
        _announcement.emit(msg)
    }
}
