package com.zywczas.commoncompose.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.zywczas.commoncompose.theme.PreviewTheme
import com.zywczas.commoncompose.theme.Spacing
import com.zywczas.commoncompose.theme.TemperatureColor

@Composable
fun KeyValue(viewEntity: KeyValueViewEntity) {
    Column {
        Text(
            text = viewEntity.key,
            modifier = Modifier.fillMaxWidth(),
            textAlign = viewEntity.textAlign,
            style = MaterialTheme.typography.labelMedium
        )
        Spacer(Modifier.height(Spacing.tiny))
        Text(
            text = viewEntity.value,
            modifier = Modifier.fillMaxWidth(),
            color = viewEntity.valueTextColor,
            textAlign = viewEntity.textAlign,
            style = MaterialTheme.typography.labelLarge
        )
    }
}

data class KeyValueViewEntity(
    val key: String,
    val value: String,
    val valueTextColor: Color = Color.Black,
    val textAlign: TextAlign = TextAlign.Start
)

@Preview(showBackground = true)
@Composable
private fun PreviewKeyValue() {
    PreviewTheme {
        KeyValue(
            KeyValueViewEntity(
                key = "Temperature",
                value = "35 °C",
                valueTextColor = TemperatureColor.Hot.value
            )
        )
    }
}
