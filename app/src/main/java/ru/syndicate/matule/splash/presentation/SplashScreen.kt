package ru.syndicate.matule.splash.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getViewModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import kotlinx.coroutines.delay
import ru.syndicate.matule.R
import ru.syndicate.matule.auth.AuthScreen
import ru.syndicate.matule.onboarding.presentation.OnboardingScreen
import ru.syndicate.matule.splash.view_model.LaunchViewModel
import ru.syndicate.matule.ui.theme.BackgroundGradient

class SplashScreen : Screen {

    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow

        val viewModel = getViewModel<LaunchViewModel>()

        val isFinishOnboarding by viewModel.isFinishOnboarding.collectAsState()

        SplashScreenContent(
            modifier = Modifier
                .fillMaxSize(),
            navigateToNext = {
                if (isFinishOnboarding)
                    navigator.replace(AuthScreen())
                else
                    navigator.replace(OnboardingScreen())
            }
        )
    }
}

@Composable
fun SplashScreenContent(
    modifier: Modifier = Modifier,
    navigateToNext: () -> Unit = { }
) {

    LaunchedEffect(Unit) {
        delay(1500)
        navigateToNext()
    }

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {

        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.svg_splash_text),
            contentDescription = "Matule me",
            tint = Color.White
        )
    }
}

@Preview
@Composable
private fun PreviewSplashScreen() {
    SplashScreenContent(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = BackgroundGradient
                )
            )
    )
}