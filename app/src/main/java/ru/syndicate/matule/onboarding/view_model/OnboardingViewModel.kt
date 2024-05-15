package ru.syndicate.matule.onboarding.view_model

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : ViewModel() {

    val pageState = MutableStateFlow(0)

    init {
        pageState.update {
            sharedPreferences.getInt("last_index_onboarding", 0)
        }
    }

    fun onEvent(event: OnboardingEvent) {

        when (event) {

            OnboardingEvent.NavigateNextPage -> {
                pageState.update { it + 1 }
                sharedPreferences.edit().putInt("last_index_onboarding", pageState.value).apply()
            }

            OnboardingEvent.FinishOnBoarding -> {
                sharedPreferences.edit().putBoolean("finish_onboarding", true).apply()
            }
        }
    }
}