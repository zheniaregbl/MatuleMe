package ru.syndicate.matule.ui

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.Ease
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.FadeTransition
import dagger.hilt.android.AndroidEntryPoint
import ru.syndicate.matule.shop_part.presentation.MainScreen
import ru.syndicate.matule.splash.presentation.SplashScreen
import ru.syndicate.matule.ui.theme.BackgroundGradient
import ru.syndicate.matule.ui.theme.MatuleTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(Color.TRANSPARENT),
            navigationBarStyle = SystemBarStyle.dark(Color.TRANSPARENT)
        )

        setContent {

            MatuleTheme {

                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) {

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                brush = Brush.verticalGradient(
                                    colors = BackgroundGradient
                                )
                            )
                    ) {

                        Navigator(SplashScreen()) { navigator ->

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
        }
    }
}