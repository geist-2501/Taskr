package com.bxsys.taskr.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

fun Modifier.fieldModifier(): Modifier {
    return this.fillMaxWidth().padding(bottom = 8.dp)
}

fun Modifier.basicButton(): Modifier {
    return this.fillMaxWidth().padding(bottom = 8.dp)
}