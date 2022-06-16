package com.bxsys.taskr.ui.screens.signin

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
import com.bxsys.taskr.ui.components.EmailField
import com.bxsys.taskr.ui.components.PasswordField
import com.bxsys.taskr.ui.components.PrimaryButton
import com.bxsys.taskr.ui.components.SecondaryButton
import com.bxsys.taskr.ui.theme.TaskrTheme

import com.bxsys.taskr.R.string as AppText

@Composable
fun SignInScreen(
    nav: (String) -> Unit,
    navFromTo: (String, String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: ISignInViewModel = hiltViewModel<SignInViewModel>(),
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

        PrimaryButton(
            text = AppText.sign_in,
            modifier = Modifier.basicButton()
        ) {
            viewModel.onSignInClick(navFromTo)
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(text = "Don't have an account?", modifier = Modifier.padding(bottom = 8.dp))
        SecondaryButton(
            text = AppText.sign_up,
            modifier = Modifier.basicButton()
        ) {
            viewModel.onSignUpClick(nav)
        }
    }
}

@Preview
@Composable
private fun PreviewSignInScreen() {
    TaskrTheme {
        SignInScreen(viewModel = MockSignInViewModel(), nav = {_ -> }, navFromTo = {_, _ -> })
    }
}