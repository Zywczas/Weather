package com.zywczas.commoncompose.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.zywczas.commoncompose.theme.Color
import com.zywczas.commoncompose.theme.Theme
import com.zywczas.commonutil.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar(
    title: String,
    onBackClick: (() -> Unit)? = null,
) {
    val textStyle = MaterialTheme.typography.titleMedium
    val iconsColor = MaterialTheme.colorScheme.primary
    val backgroundColor = Color.ScreenBackground
    TopAppBar(
        title = {
            Text(
                text = title,
                style = textStyle
            )
        },
        navigationIcon = onBackClick?.let {
            {
                IconButton(
                    onClick = onBackClick,
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.content_description_navigate_back),
                    )
                }
            }
        } ?: {},
        colors = TopAppBarColors(
            containerColor = backgroundColor,
            scrolledContainerColor = backgroundColor,
            navigationIconContentColor = iconsColor,
            titleContentColor = textStyle.color,
            actionIconContentColor = iconsColor
        )
    )
}

@Preview
@Composable
private fun PreviewToolbar() {
    Theme.Preview {
        Toolbar(
            title = "PreviewScreen",
            onBackClick = {},
        )
    }
}
