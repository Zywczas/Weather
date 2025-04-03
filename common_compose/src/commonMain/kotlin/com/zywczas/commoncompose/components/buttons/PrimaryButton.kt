package com.zywczas.commoncompose.components.buttons

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.zywczas.commoncompose.theme.Theme
import com.zywczas.commonutils.OnClick
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun PrimaryButton(
    text: String,
    onClick: OnClick,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
    ) {
        Text(text)
    }
}

@Preview
@Composable
private fun PreviewPrimaryButton() {
    Theme.Preview {
        PrimaryButton(
            text = "Next hours",
            onClick = {}
        )
    }
}
