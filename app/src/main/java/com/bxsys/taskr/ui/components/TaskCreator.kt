package com.bxsys.taskr.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TaskCreator(
    modifier: Modifier = Modifier,
    onDone: () -> Unit
) {
    var text by remember { mutableStateOf("") }
    Row(modifier = modifier) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = text,
            onValueChange = { text = it },
            label = { Text("New Task") },
            keyboardActions = KeyboardActions(onDone = { onDone() })
        )
    }
}

@Preview
@Composable
private fun PreviewTaskCreator() {
    TaskCreator(onDone = { })
}
