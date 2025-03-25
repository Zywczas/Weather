package com.zywczas.commoncompose.components.buttons

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.zywczas.commoncompose.theme.PreviewTheme
import com.zywczas.commoncompose.theme.Spacing

@Composable
fun PrimaryButton(
    @StringRes text: Int,
    horizontalPadding: Dp = Spacing.horizontalPadding,
    onClick: () -> Unit
) {
    PrimaryButton(
        text = stringResource(text),
        horizontalPadding = horizontalPadding,
        onClick = onClick
    )
}

@Composable
fun PrimaryButton(
    text: String,
    horizontalPadding: Dp = Spacing.horizontalPadding,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = horizontalPadding)
    ) {
        Text(text)
    }
}

@Preview
@Composable
private fun Preview() {
    PreviewTheme {
        PrimaryButton(
            text = "Next hours",
            onClick = {}
        )
    }
}
