package com.zywczas.weather.uicomponents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.zywczas.weather.models.City
import com.zywczas.weather.ui.theme.AppTheme
import com.zywczas.weather.ui.theme.Spacing

@Composable
fun CityListItem(city: City, onClick: () -> Unit) {
    Column(
        Modifier
            .padding(Spacing.xxs)
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Text(city.name)
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewCity() {
    AppTheme {
        CityListItem(
            city = City(
                name = "Bydgoszcz"
            ),
            onClick = {}
        )
    }
}
