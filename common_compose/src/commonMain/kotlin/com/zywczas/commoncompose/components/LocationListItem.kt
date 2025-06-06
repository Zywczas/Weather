package com.zywczas.commoncompose.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.zywczas.commoncompose.theme.Spacing
import com.zywczas.commoncompose.theme.Theme
import com.zywczas.commonutils.OnClick
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun LocationListItem(cityName: String, onClick: OnClick) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Text(
            text = cityName,
            modifier = Modifier
                .padding(
                    vertical = Spacing.listItemVerticalOuter,
                    horizontal = Spacing.screenBorder
                ),
            style = MaterialTheme.typography.bodyLarge,
        )
    }
}

@Preview
@Composable
private fun PreviewLocationListItem() {
    Theme.Preview {
        LocationListItem(
            cityName = "Bydgoszcz",
            onClick = {}
        )
    }
}
