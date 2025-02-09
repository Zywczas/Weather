package com.zywczas.commoncompose.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.zywczas.commoncompose.theme.PreviewTheme

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
    PreviewTheme {
        Toolbar("PreviewScreen")
    }
}
