package com.bxsys.taskr.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bxsys.taskr.model.Task

@Composable
fun TaskCreator(
    modifier: Modifier = Modifier,
    onNewTask: (Task) -> Unit
) {
    var text by remember { mutableStateOf("") }
    Row(modifier = modifier) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = text,
            onValueChange = { text = it },
            label = { Text("New Task") },
            singleLine = true,
            keyboardActions = KeyboardActions(onDone = {
                onNewTask(Task(content = text))
                text = ""
            })
        )
    }
}

@Preview
@Composable
private fun PreviewTaskCreator() {
    TaskCreator(onNewTask = { })
}
