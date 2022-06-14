package com.bxsys.taskr.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType

import com.bxsys.taskr.R.string as AppText
import com.bxsys.taskr.R.drawable as AppIcon

@Composable
fun BasicTextField(
    @StringRes placeholder: Int,
    value: String,
    onNewValue: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = onNewValue,
        placeholder = { Text(stringResource(placeholder)) },
        modifier = modifier
    )
}

@Composable
fun EmailField(
    value: String,
    onNewValue: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = onNewValue,
        placeholder = { Text(stringResource(AppText.email)) },
        leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "Email") },
        modifier = modifier
    )
}

@Composable
fun BasicPasswordField(
    @StringRes placeholder: Int,
    value: String,
    onNewValue: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = onNewValue,
        placeholder = { Text(stringResource(placeholder)) },
        leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "Lock") },
        trailingIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(painter = painterResource(AppIcon.ic_baseline_visibility_24), contentDescription = "Visibility")
            }
        },
        modifier = modifier
    )
}

@Composable
fun PasswordField(
    value: String,
    onNewValue: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    BasicPasswordField(
        placeholder = AppText.password,
        value = value,
        onNewValue = onNewValue,
        modifier = modifier
    )
}

@Composable
fun RepeatPasswordField(
    value: String,
    onNewValue: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    BasicPasswordField(
        placeholder = AppText.repeat_password,
        value = value,
        onNewValue = onNewValue,
        modifier = modifier
    )
}