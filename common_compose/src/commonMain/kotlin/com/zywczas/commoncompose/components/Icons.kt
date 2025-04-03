package com.zywczas.commoncompose.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import com.zywczas.commoncompose.theme.Theme
import com.zywczas.weather.resources.commonutils.Res
import com.zywczas.weather.resources.commonutils.content_description_condition_sunny
import com.zywczas.weather.resources.commonutils.ic_condition_sunny
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun LargeIcon(
    icon: DrawableResource,
    contentDescription: StringResource,
) {
    Image(
        painter = painterResource(icon),
        contentDescription = stringResource(contentDescription),
        modifier = Modifier.size(48.dp)
    )
}

@Preview
@Composable
private fun PreviewLargeIcon() {
    Theme.Preview {
        LargeIcon(
            Res.drawable.ic_condition_sunny,
            Res.string.content_description_condition_sunny,
        )
    }
}

@Composable
fun SmallIcon(
    icon: DrawableResource,
    contentDescription: StringResource,
    tint: Color? = null
) {
    Image(
        painter = painterResource(icon),
        contentDescription = stringResource(contentDescription),
        modifier = Modifier.size(24.dp),
        colorFilter = tint?.let { ColorFilter.tint(it) }
    )
}

@Preview
@Composable
private fun PreviewSmallIcon() {
    Theme.Preview {
        SmallIcon(
            Res.drawable.ic_condition_sunny,
            Res.string.content_description_condition_sunny,
            tint = com.zywczas.commoncompose.theme.Color.Weather.LightCloud
        )
    }
}
