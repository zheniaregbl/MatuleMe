package ru.syndicate.matule.auth.view_model

sealed interface AuthEvent {

    data class ChangeEmail(
        val email: String
    ) : AuthEvent

    data class ChangePassword(
        val password: String
    ) : AuthEvent

    data class ChangeName(
        val name: String
    ) : AuthEvent

    data class ChangeOTP(
        val text: String
    ) : AuthEvent
}