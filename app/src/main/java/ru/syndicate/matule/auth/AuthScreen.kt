package ru.syndicate.matule.auth

import android.content.Context
import android.content.ContextWrapper
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.Ease
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.FadeTransition
import ru.syndicate.matule.auth.presentation.sign_in.SignInScreen

class AuthScreen : Screen {

    @Composable
    override fun Content() {

        LocalContext.current.findActivity()?.enableEdgeToEdge()

        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = Color.White
        ) {

            Navigator(SignInScreen()) { navigator ->

                FadeTransition(
                    navigator = navigator,
                    animationSpec = tween(
                        durationMillis = 200,
                        easing = Ease
                    )
                )
            }
        }
    }
}

internal tailrec fun Context.findActivity(): ComponentActivity? =
    when (this) {
        is ComponentActivity -> this
        is ContextWrapper -> baseContext.findActivity()
        else -> null
    }