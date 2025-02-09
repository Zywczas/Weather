package com.zywczas.commoncompose.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.zywczas.commoncompose.theme.AppTheme
import com.zywczas.commoncompose.theme.Spacing

@Composable
fun CityListItem(cityName: String, onClick: () -> Unit) {
    Text(
        text = cityName,
        modifier = Modifier
            .padding(Spacing.xxs)
            .fillMaxWidth()
            .clickable { onClick() }
    )
}

@Preview(showBackground = true)
@Composable
private fun PreviewCity() {
    AppTheme {
        CityListItem(
            cityName = "Bydgoszcz",
            onClick = {}
        )
    }
}
