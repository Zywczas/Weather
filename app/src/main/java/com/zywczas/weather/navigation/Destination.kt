package com.zywczas.weather.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlin.reflect.KClass

abstract class Destination {
    open val route: String = this::class.simpleName ?: throw ObjectNameException()
}

abstract class DestinationWithArgs<T : Any>(private val navArgsClass: KClass<T>) : Destination() {

    private val argKey: String = navArgsClass.simpleName ?: throw ObjectNameException()
    private val gson: Gson = GsonBuilder().create()
    private val arguments: List<NamedNavArgument> = listOf(navArgument(argKey) { type = NavType.StringType })

    final override val route: String = "${super.route}/{$argKey}"

    fun getDestinationWithArgs(args: T): String {
        val navArgsJson = gson.toJson(args)
        return "${super.route}/$navArgsJson"
    }

    fun composableWithArgs(
        navGraphBuilder: NavGraphBuilder,
        content: @Composable AnimatedContentScope.(NavBackStackEntry, args: T) -> Unit
    ) {
        navGraphBuilder.composable(route = route, arguments = arguments) { navBackStackEntry ->
            val json: String = navBackStackEntry.arguments?.getString(argKey)
                ?: throw IllegalArgumentException("Missing arguments for destination '${route}'. Before using this function, use 'fun getDestinationWithArgs(args: T)'.")
            val args = gson.fromJson(json, navArgsClass.java)
            content(navBackStackEntry, args)
        }
    }
}

private class ObjectNameException : IllegalArgumentException("Object name cannot be null")
