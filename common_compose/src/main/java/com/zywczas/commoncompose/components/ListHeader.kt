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
import androidx.compose.ui.tooling.preview.Preview
import com.zywczas.commoncompose.theme.PreviewTheme
import com.zywczas.commoncompose.theme.PrimaryColor
import com.zywczas.commoncompose.theme.Spacing

@Composable
fun ListHeader(text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(PrimaryColor),
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge,
            color = Color.White,
            modifier = Modifier.padding(horizontal = Spacing.horizontalPadding, vertical = Spacing.verticalPadding)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    PreviewTheme {
        ListHeader(
            text = "Recent searches"
        )
    }
}
