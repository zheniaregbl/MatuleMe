package ru.syndicate.matule.splash.view_model

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LaunchViewModel @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : ViewModel() {

    val isFinishOnboarding = MutableStateFlow(false)

    init {
        checkFinishOnboarding()
    }

    private fun checkFinishOnboarding() {

        viewModelScope.launch(Dispatchers.IO) {

            isFinishOnboarding.update {
                sharedPreferences.getBoolean("finish_onboarding", false)
            }
        }
    }
}