package com.bxsys.taskr.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bxsys.taskr.ui.components.TaskCreator
import com.bxsys.taskr.ui.components.TaskItem

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val tasks = homeViewModel.tasks

    Column(modifier) {
        TaskCreator(
            Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            onNewTask = homeViewModel::handleNewTaskClick
        )
        LazyColumn {
            items(tasks, key = {it.id}) { task ->
                TaskItem(task = task, onCloseTask = { homeViewModel.handleDeleteTaskClick(it) })
            }
        }
    }
    
    DisposableEffect(homeViewModel) {
        homeViewModel.addListener()
        onDispose {
            homeViewModel.removeListener()
        }
    }
}