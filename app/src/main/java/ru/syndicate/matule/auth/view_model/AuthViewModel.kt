package ru.syndicate.matule.auth.view_model

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor() : ViewModel() {

    val emailText = MutableStateFlow("")
    val nameText = MutableStateFlow("")
    val passwordText = MutableStateFlow("")
    val optText = MutableStateFlow("")

    fun onEvent(event: AuthEvent) {

        when (event) {
            is AuthEvent.ChangeEmail -> emailText.update { event.email }
            is AuthEvent.ChangeName -> nameText.update { event.name }
            is AuthEvent.ChangePassword -> passwordText.update { event.password }
            is AuthEvent.ChangeOTP -> optText.update { event.text }
        }
    }
}