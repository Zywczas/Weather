package com.zywczas.weather.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.google.gson.GsonBuilder
import kotlin.reflect.KClass


abstract class Destination {
    open val route: String = this::class.simpleName.toString()
}

abstract class DestinationWithArgs<T : Any>(private val navArgs: KClass<T>) : Destination() {

    private val arguments: List<NamedNavArgument> = listOf(navArgument(navArgs.simpleName.toString()) { type = NavType.StringType })
    final override val route = "${super.route}/{${navArgs.simpleName}}"

    fun getDestinationWithArgs(args: T): String {
        val navArgsJson = GsonBuilder().create().toJson(args)
        return "${super.route}/$navArgsJson"
    }

    fun composableWithArgs(
        navGraphBuilder: NavGraphBuilder,
        content: @Composable AnimatedContentScope.(NavBackStackEntry, args: T) -> Unit
    ) {
        navGraphBuilder.composable(route = route, arguments = arguments) { navBackStackEntry ->
            content(navBackStackEntry, getArgs(navBackStackEntry))
        }
    }

    private fun getArgs(navBackStackEntry: NavBackStackEntry): T = GsonBuilder().create().fromJson(navBackStackEntry.arguments?.getString(navArgs.simpleName), navArgs.java)
}
