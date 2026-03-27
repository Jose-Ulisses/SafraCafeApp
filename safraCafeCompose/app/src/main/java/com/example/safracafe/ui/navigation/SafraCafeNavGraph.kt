package com.example.safracafe.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.safracafe.HomeDestination
import com.example.safracafe.ui.home.HomeScreen
import com.example.safracafe.ui.item.LavouraDetailsDestination
import com.example.safracafe.ui.item.LavouraDetailsScreen
import com.example.safracafe.ui.item.LavouraEditDestination
import com.example.safracafe.ui.item.LavouraEditScreen
import com.example.safracafe.ui.item.LavouraEntryDestination
import com.example.safracafe.ui.item.LavouraEntryScreen

@Composable
fun SafraCafeNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = HomeDestination.route,
        modifier = modifier
    ) {
        composable(route = HomeDestination.route) {
            HomeScreen(
                navigateToLavouraEntry = { navController.navigate(LavouraEntryDestination.route) },
                navigateToLavouraUpdate = {navController.navigate("${LavouraDetailsDestination.route}/${it}")}
            )
        }

        composable(route = LavouraEntryDestination.route) {
            LavouraEntryScreen(
                navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() }
            )
        }

        composable(
            route = LavouraDetailsDestination.routeWithArgs,
            arguments = listOf(navArgument(LavouraDetailsDestination.lavouraIdArg) {
                type = NavType.IntType
            })
        ) {
            LavouraDetailsScreen(
                navigateToEditLavoura = { navController.navigate("${LavouraEditDestination.route}/$it") },
                navigateBack = { navController.navigateUp() }
            )
        }

        composable(
            route = LavouraEditDestination.routeWithArgs,
            arguments = listOf(navArgument(LavouraEditDestination.lavouraIdArg) {
                type = NavType.IntType
            })
        ) {
            LavouraEditScreen(
                navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() }
            )
        }
    }
}