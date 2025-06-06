package com.zywczas.commoncompose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.zywczas.commoncompose.theme.Spacing
import com.zywczas.commoncompose.theme.Theme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ListHeader(text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary),
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge,
            color = Color.White,
            modifier = Modifier.padding(horizontal = Spacing.screenBorder, vertical = Spacing.listItemVerticalOuter)
        )
    }
}

@Preview
@Composable
private fun PreviewListHeader() {
    Theme.Preview {
        ListHeader(
            text = "Recent searches"
        )
    }
}
