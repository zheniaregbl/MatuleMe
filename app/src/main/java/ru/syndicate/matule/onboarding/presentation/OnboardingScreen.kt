package ru.syndicate.matule.onboarding.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getViewModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import ru.syndicate.matule.R
import ru.syndicate.matule.auth.AuthScreen
import ru.syndicate.matule.onboarding.presentation.components.BackgroundIcons
import ru.syndicate.matule.onboarding.presentation.components.IndicatorWithText
import ru.syndicate.matule.onboarding.view_model.OnboardingEvent
import ru.syndicate.matule.onboarding.view_model.OnboardingViewModel
import ru.syndicate.matule.ui.theme.BackgroundGradient
import ru.syndicate.matule.ui.theme.ButtonWhite
import ru.syndicate.matule.ui.theme.TextBlack

class OnboardingScreen : Screen {

    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow

        val viewModel = getViewModel<OnboardingViewModel>()

        val pageState by viewModel.pageState.collectAsState()

        OnboardingScreenContent(
            modifier = Modifier
                .fillMaxSize()
                .systemBarsPadding(),
            pageState = pageState,
            navigateToNextPage = {
                viewModel.onEvent(
                    OnboardingEvent.NavigateNextPage
                )
            },
            navigateToAuth = {
                viewModel.onEvent(OnboardingEvent.FinishOnBoarding)
                navigator.replace(AuthScreen())
            }
        )
    }
}

@Composable
fun OnboardingScreenContent(
    modifier: Modifier = Modifier,
    pageState: Int = 0,
    navigateToNextPage: () -> Unit = { },
    navigateToAuth: () -> Unit = { }
) {

    Box(
        modifier = modifier
    ) {

        BackgroundIcons(
            modifier = Modifier
                .fillMaxSize(),
            pageState = pageState
        )

        AnimatedVisibility(
            modifier = Modifier
                .fillMaxSize(),
            visible = pageState == 0,
            enter = fadeIn(),
            exit = fadeOut()
        ) {

            Image(
                modifier = Modifier
                    .align(Alignment.Center)
                    .fillMaxWidth()
                    .background(
                        color = Color.Transparent
                    ),
                painter = painterResource(id = R.drawable.page1),
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )
        }

        AnimatedVisibility(
            modifier = Modifier
                .fillMaxSize(),
            visible = pageState == 1,
            enter = fadeIn(),
            exit = fadeOut()
        ) {

            Image(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(
                        bottom = 250.dp
                    )
                    .fillMaxWidth()
                    .background(
                        color = Color.Transparent
                    ),
                painter = painterResource(id = R.drawable.page2),
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )
        }

        AnimatedVisibility(
            modifier = Modifier
                .fillMaxSize(),
            visible = pageState == 2,
            enter = fadeIn(),
            exit = fadeOut()
        ) {

            Image(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(
                        bottom = 250.dp
                    )
                    .fillMaxWidth()
                    .background(
                        color = Color.Transparent
                    ),
                painter = painterResource(id = R.drawable.page3),
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )
        }

        IndicatorWithText(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            pageState = pageState
        )

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(
                    bottom = 36.dp
                )
                .padding(
                    horizontal = 20.dp
                )
                .clip(RoundedCornerShape(13.dp))
                .background(
                    color = ButtonWhite
                )
                .clickable {
                    if (pageState != 2)
                        navigateToNextPage()
                    else
                        navigateToAuth()
                }
                .padding(
                    vertical = 17.dp
                ),
            contentAlignment = Alignment.Center
        ) {

            Text(
                text = if (pageState == 0) "Начать" else "Далее",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                color = TextBlack
            )
        }
    }
}

@Preview
@Composable
private fun PreviewOnboardingScreen() {
    OnboardingScreenContent(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = BackgroundGradient
                )
            )
    )
}