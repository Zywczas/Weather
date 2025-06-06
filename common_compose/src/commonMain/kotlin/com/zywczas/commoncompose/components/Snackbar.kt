package com.zywczas.commoncompose.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun Snackbar(hostState: SnackbarHostState, withBottomBarInsetSpacer: Boolean = false) {
    Box(Modifier.fillMaxSize()) {
        Column(modifier = Modifier.align(Alignment.BottomCenter)) {
            SnackbarHost(hostState)

            if (withBottomBarInsetSpacer) {
                BottomBarInsetSpacer()
            }
        }
    }
}
