package com.bxsys.taskr.common

import androidx.navigation.NavController

fun NavController.popUp() {
    popBackStack()
}

fun NavController.nav(route: String) {
    navigate(route) {
        launchSingleTop = true
    }
}

fun NavController.navFromTo(from: String, to: String) {
    navigate(to) {
        launchSingleTop = true
        popUpTo(from) { inclusive = true }
    }
}