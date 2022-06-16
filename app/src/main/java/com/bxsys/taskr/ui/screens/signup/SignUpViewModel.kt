package com.bxsys.taskr.ui.screens.signup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewModelScope
import com.bxsys.taskr.HOME_SCREEN
import com.bxsys.taskr.SIGN_IN_SCREEN
import com.bxsys.taskr.SIGN_UP_SCREEN
import com.bxsys.taskr.TaskrViewModel
import com.bxsys.taskr.model.service.FirebaseUserService
import com.bxsys.taskr.model.service.api.ILogService
import com.bxsys.taskr.model.service.api.ISnackbarService
import com.bxsys.taskr.model.service.api.IUserService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

interface ISignUpViewModel {
    var email: String
    var password: String
    var repeatPassword: String

    fun onEmailChange(newVal: String)
    fun onPasswordChange(newVal: String)
    fun onRepeatPasswordChange(newVal: String)

    fun onSignUpClick(navFromTo: (String, String) -> Unit)
    fun onSignInClick(nav: (String) -> Unit)
}

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val userService: IUserService,
    logService: ILogService,
    snackbarService: ISnackbarService
): TaskrViewModel(logService, snackbarService), ISignUpViewModel {

    override var email: String by mutableStateOf("")
    override var password: String by mutableStateOf("")
    override var repeatPassword: String by mutableStateOf("")

    override fun onEmailChange(newVal: String) {
        email = newVal
    }

    override fun onPasswordChange(newVal: String) {
        password = newVal
    }

    override fun onRepeatPasswordChange(newVal: String) {
        repeatPassword = newVal
    }

    override fun onSignUpClick(navFromTo: (String, String) -> Unit) {
        // TODO Implement error handling and a snackbar.

        viewModelScope.launch(showErrorExceptionHandler) {
            userService.signUp(email, password) { error ->
                if (error == null) {
                    navFromTo(SIGN_UP_SCREEN, HOME_SCREEN)
                } else {
                    onError(error)
                }
            }
        }
    }

    override fun onSignInClick(nav: (String) -> Unit) {
        nav(SIGN_IN_SCREEN)
    }
}

class MockSignUpViewModel: ISignUpViewModel {
    override var email: String = ""
    override var password: String = ""
    override var repeatPassword: String = ""

    override fun onEmailChange(newVal: String) {}
    override fun onPasswordChange(newVal: String) {}
    override fun onRepeatPasswordChange(newVal: String) {}
    override fun onSignUpClick(navFromTo: (String, String) -> Unit) {}
    override fun onSignInClick(nav: (String) -> Unit) {}

}