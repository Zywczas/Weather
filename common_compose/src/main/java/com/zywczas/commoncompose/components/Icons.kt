package com.zywczas.commoncompose.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zywczas.commoncompose.theme.Theme
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
private fun PreviewLargeIcon() {
    Theme.Preview {
        LargeIcon(
            R.drawable.ic_condition_sunny,
            R.string.content_description_condition_sunny,
        )
    }
}

@Composable
fun SmallIcon(
    @DrawableRes icon: Int,
    @StringRes contentDescription: Int,
    tint: Color? = null
) {
    Image(
        painter = painterResource(icon),
        contentDescription = stringResource(contentDescription),
        modifier = Modifier.size(24.dp),
        colorFilter = tint?.let { ColorFilter.tint(it) }
    )
}

@Preview(showBackground = true)
@Composable
private fun PreviewSmallIcon() {
    Theme.Preview {
        SmallIcon(
            R.drawable.ic_condition_sunny,
            R.string.content_description_condition_sunny,
            tint = com.zywczas.commoncompose.theme.Color.Weather.LightCloud
        )
    }
}
