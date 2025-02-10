package com.zywczas.commoncompose.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.zywczas.commoncompose.theme.AppTheme
import com.zywczas.commoncompose.theme.Spacing

@Composable
fun LocationListItem(cityName: String, onClick: () -> Unit) {
    Text(
        text = cityName,
        modifier = Modifier
            .padding(
                vertical = Spacing.xxs,
                horizontal = Spacing.m
            )
            .fillMaxWidth()
            .clickable { onClick() },
        style = MaterialTheme.typography.bodyLarge,
    )
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    AppTheme {
        LocationListItem(
            cityName = "Bydgoszcz",
            onClick = {}
        )
    }
}
