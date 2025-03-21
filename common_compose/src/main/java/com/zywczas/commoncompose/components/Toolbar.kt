package com.zywczas.commoncompose.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.zywczas.commoncompose.theme.PreviewTheme
import com.zywczas.commoncompose.theme.PrimaryColor
import com.zywczas.commonutil.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar(
    title: String,
    onBackClick: (() -> Unit)? = null,
) {
    TopAppBar(
        title = { Text(title) },
        navigationIcon = onBackClick?.let {
            {
                IconButton(
                    onClick = onBackClick,
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.content_description_navigate_back),
                        tint = PrimaryColor
                    )
                }
            }
        } ?: {},
    )
}

@Preview
@Composable
private fun Preview() {
    PreviewTheme {
        Toolbar(
            title = "PreviewScreen",
            onBackClick = {},
        )
    }
}
