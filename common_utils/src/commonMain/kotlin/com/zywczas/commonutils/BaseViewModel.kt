package com.zywczas.commonutils

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow

abstract class BaseViewModel : ViewModel() {

    private val _announcement = Channel<String>(capacity = Channel.BUFFERED)
    val announcement: Flow<String> = _announcement.receiveAsFlow()

    suspend fun showError(msg: String) {
        _announcement.send(msg)
    }
}
