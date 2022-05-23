package com.bxsys.taskr.ui.views.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bxsys.taskr.MainViewModel
import com.bxsys.taskr.model.Task
import com.bxsys.taskr.ui.components.TaskCreator
import com.bxsys.taskr.ui.components.TaskList

@Preview(showBackground = true)
@Composable
fun HomeView(
    modifier: Modifier = Modifier,
    homeViewModel: MainViewModel = viewModel()
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