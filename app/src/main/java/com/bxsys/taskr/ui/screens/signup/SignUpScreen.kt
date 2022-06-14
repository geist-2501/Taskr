package com.bxsys.taskr.ui.screens.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bxsys.taskr.common.basicButton
import com.bxsys.taskr.common.fieldModifier
import com.bxsys.taskr.ui.components.*
import com.bxsys.taskr.ui.theme.TaskrTheme

import com.bxsys.taskr.R.string as AppText

@Composable
fun SignUpScreen(
    nav: (String) -> Unit,
    navFromTo: (String, String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: ISignUpViewModel = hiltViewModel<SignUpViewModel>()
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .padding(16.dp),
    ) {
        val fieldModifier = Modifier.fieldModifier()

        EmailField(
            value = viewModel.email,
            onNewValue = viewModel::onEmailChange,
            fieldModifier
        )

        PasswordField(
            value = viewModel.password,
            onNewValue = viewModel::onPasswordChange,
            fieldModifier
        )

        RepeatPasswordField(
            value = viewModel.repeatPassword,
            onNewValue = viewModel::onRepeatPasswordChange,
            fieldModifier
        )

        PrimaryButton(
            text = AppText.sign_up,
            modifier = Modifier.basicButton()
        ) {
            viewModel.onSignUpClick(navFromTo)
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(text = "Already have an account?", modifier = Modifier.padding(bottom = 8.dp))
        SecondaryButton(
            text = AppText.sign_up,
            modifier = Modifier.basicButton()
        ) {
            viewModel.onSignInClick(nav)
        }
    }
}

@Preview
@Composable
private fun PreviewSignInScreen() {
    TaskrTheme {
        SignUpScreen(viewModel = MockSignUpViewModel(), nav = { }, navFromTo = { _, _ -> })
    }
}