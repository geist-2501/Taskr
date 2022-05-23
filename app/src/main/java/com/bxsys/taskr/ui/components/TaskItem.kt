package com.bxsys.taskr.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bxsys.taskr.model.Task
import com.bxsys.taskr.ui.theme.TaskrTheme

@Composable
fun TaskItem(
    modifier: Modifier = Modifier,
    task: Task,
    onCloseTask: (Task) -> Unit
) {
    Card(modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.padding(4.dp).absolutePadding(left=16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(task.content)
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = { onCloseTask(task) }) {
                Icon(Icons.Default.Close, contentDescription = "Close")
            }
        }
    }
}

@Preview
@Composable
private fun PreviewTaskItem() {
    TaskrTheme {
        TaskItem(task = Task(1, "Task item"), onCloseTask = {})
    }
}