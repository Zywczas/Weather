package com.zywczas.commoncompose.components

import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HorizontalListItemDivider() {
    HorizontalDivider(
        color = MaterialTheme.colorScheme.primary
    )
}

@Composable
fun VerticalListItemDivider(modifier: Modifier = Modifier) {
    VerticalDivider(
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier
    )
}

