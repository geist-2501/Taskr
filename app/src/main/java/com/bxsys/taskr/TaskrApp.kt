package com.bxsys.taskr

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bxsys.taskr.ui.theme.TaskrTheme
import com.bxsys.taskr.ui.screens.home.HomeScreen

@Composable
fun TaskrApp() {
    val navController = rememberNavController()
    TaskrTheme {
        Surface(color = MaterialTheme.colors.background) {
            Scaffold { padding ->
                NavHost(
                    navController = navController,
                    startDestination = HOME_SCREEN,
                    modifier = Modifier.padding(padding)
                ) {
                    taskrGraph()
                }
            }
        }
    }
}

fun NavGraphBuilder.taskrGraph() {
    composable(HOME_SCREEN) {
        HomeScreen()
    }
}