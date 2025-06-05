package com.zywczas.commoncompose.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.zywczas.commoncompose.theme.Spacing
import com.zywczas.commoncompose.theme.Theme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun KeyValue(viewEntity: KeyValueViewEntity) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = viewEntity.key,
            style = MaterialTheme.typography.labelMedium
        )
        Spacer(Modifier.height(Spacing.listItemVerticalInner))
        Text(
            text = viewEntity.value,
            style = MaterialTheme.typography.labelLarge
        )
    }
}

data class KeyValueViewEntity(
    val key: String,
    val value: String,
)

@Preview
@Composable
private fun PreviewKeyValue() {
    Theme.Preview {
        KeyValue(
            KeyValueViewEntity(
                key = "Temperature",
                value = "35 °C"
            )
        )
    }
}
