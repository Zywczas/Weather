package com.zywczas.weather.uicomponents

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.zywczas.weather.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar(title: String) {
    TopAppBar(
        title = { Text(title) },
    )
}

@Preview
@Composable
private fun PreviewToolbar() {
    AppTheme {
        Toolbar("PreviewScreen")
    }
}
