package com.bxsys.taskr.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bxsys.taskr.TaskrViewModel
import com.bxsys.taskr.ui.components.TaskCreator
import com.bxsys.taskr.ui.components.TaskList

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel = viewModel()
) {
    Column(modifier) {
        TaskCreator(
            Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            onNewTask = homeViewModel::handleNewTask
        )
        TaskList(
            tasks = homeViewModel.tasks,
            onCloseTask = homeViewModel::handleRemoveTask
        )
    }
}