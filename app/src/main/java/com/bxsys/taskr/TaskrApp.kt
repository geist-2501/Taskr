package com.bxsys.taskr

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bxsys.taskr.common.nav
import com.bxsys.taskr.common.navFromTo
import com.bxsys.taskr.ui.theme.TaskrTheme
import com.bxsys.taskr.ui.screens.home.HomeScreen
import com.bxsys.taskr.ui.screens.signin.SignInScreen
import com.bxsys.taskr.ui.screens.signup.SignUpScreen
import com.bxsys.taskr.ui.screens.splash.SplashScreen

@Composable
fun TaskrApp(
    viewModel: TaskrViewModel = hiltViewModel()
) {
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()

    TaskrTheme {
        Surface(color = MaterialTheme.colors.background) {
            Scaffold(
                snackbarHost = {
                    SnackbarHost(hostState = viewModel.snackbarHostState)
                },
                scaffoldState = scaffoldState
            ) { padding ->
                NavHost(
                    navController = navController,
                    startDestination = SPLASH_SCREEN,
                    modifier = Modifier.padding(padding)
                ) {
                    taskrGraph(navController)
                }
            }
        }
    }
}

fun NavGraphBuilder.taskrGraph(navController: NavController) {
    composable(SPLASH_SCREEN) {
        SplashScreen({from, to -> navController.navFromTo(from, to)})
    }

    composable(SIGN_IN_SCREEN) {
        SignInScreen(
            nav = { dest -> navController.nav(dest) },
            navFromTo = { from, to -> navController.navFromTo(from, to) }
        )
    }

    composable(SIGN_UP_SCREEN) {
        SignUpScreen(
            nav = { dest -> navController.nav(dest) },
            navFromTo = { from, to -> navController.navFromTo(from, to) }
        )
    }

    composable(HOME_SCREEN) {
        HomeScreen()
    }
}