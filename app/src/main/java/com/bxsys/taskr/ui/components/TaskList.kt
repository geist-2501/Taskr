package com.bxsys.taskr.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bxsys.taskr.model.Task

@Composable
fun TaskList(
    modifier: Modifier = Modifier,
    tasks: List<Task>,
    onCloseTask: (Task) -> Unit
) {
    LazyColumn(
        modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(tasks) { task ->
            TaskItem(task = task, onCloseTask = onCloseTask)
        }
    }
}