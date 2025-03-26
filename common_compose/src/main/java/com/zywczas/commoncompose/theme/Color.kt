package com.zywczas.commoncompose.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.zywczas.commonutil.R

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val BlueGrotto = Color(0xFF03A9F4)
val PrimaryColorLight = BlueGrotto
val FunctionDisabledLight = Color(0xFF7F878E)

val LightCloud: Color @Composable get() = Color(LocalContext.current.getColor(R.color.cloud_light))
