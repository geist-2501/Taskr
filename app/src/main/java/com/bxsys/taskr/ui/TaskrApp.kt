package com.bxsys.taskr.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bxsys.taskr.data.getDummyTaskData
import com.bxsys.taskr.ui.components.TaskList
import com.bxsys.taskr.ui.theme.TaskrTheme
import com.bxsys.taskr.ui.views.home.HomeView

@Composable
fun TaskrApp() {
    val navController = rememberNavController()
    TaskrTheme {
        Scaffold { padding ->
            NavHost(
                navController = navController,
                startDestination = MainDestinations.HOME_ROUTE,
                modifier = Modifier.padding(padding)
            ) {
                composable(MainDestinations.HOME_ROUTE) {
                    HomeView()
                }
            }
        }
    }
}