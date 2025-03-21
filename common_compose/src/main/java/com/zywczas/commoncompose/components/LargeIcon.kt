package com.zywczas.commoncompose.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zywczas.commonutil.R

@Composable
fun LargeIcon(
    @DrawableRes icon: Int,
    @StringRes contentDescription: Int,
) {
    Image(
        painter = painterResource(icon),
        contentDescription = stringResource(contentDescription),
        modifier = Modifier.size(48.dp)
    )
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    LargeIcon(
        R.drawable.ic_condition_sunny,
        R.string.content_description_condition_sunny,
    )
}
