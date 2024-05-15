package ru.syndicate.matule.onboarding.view_model

sealed interface OnboardingEvent {

    data object NavigateNextPage : OnboardingEvent

    data object FinishOnBoarding: OnboardingEvent
}