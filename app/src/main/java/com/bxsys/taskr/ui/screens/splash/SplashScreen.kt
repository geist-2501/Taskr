package com.bxsys.taskr.ui.screens.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bxsys.taskr.BuildConfig
import com.bxsys.taskr.ui.theme.TaskrTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navFromTo: (String, String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: ISplashViewModel = hiltViewModel<SplashViewModel>()
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Taskr", fontSize = 30.sp)
            Spacer(Modifier.height(8.dp))
            CircularProgressIndicator(color = MaterialTheme.colors.onBackground)
        }
        Column(
            modifier = Modifier.weight(0.2f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Footer(BuildConfig.VERSION_NAME)
        }
    }

    LaunchedEffect(true) {
        delay(1000L)
        viewModel.onAppStart(navFromTo)
    }
}

@Composable
fun Footer(
    versionNum: String,
    color: Color = Color.Gray
) {
    Text(
        buildAnnotatedString {
            append("A ")
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                append("BXSYS")
            }
            append(" product")
        },
        color = color
    )
    Text("ver. $versionNum", color = color)
}

@Preview
@Composable
private fun PreviewSplashScreen() {
    TaskrTheme {
        SplashScreen(navFromTo = {_, _ -> }, viewModel = MockSplashViewModel())
    }
}