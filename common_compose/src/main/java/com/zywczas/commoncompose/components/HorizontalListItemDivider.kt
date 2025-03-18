package com.zywczas.commoncompose.components

import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun HorizontalListItemDivider(itemIndex: Int, lastIndex: Int) {
    if (itemIndex < lastIndex) {
        HorizontalDivider(
            color = MaterialTheme.colorScheme.primary
        )
    }
}
