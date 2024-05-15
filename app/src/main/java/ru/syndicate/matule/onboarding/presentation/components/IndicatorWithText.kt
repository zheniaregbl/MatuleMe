package ru.syndicate.matule.onboarding.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.Ease
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.syndicate.matule.ui.theme.ButtonWhite

@Composable
fun IndicatorWithText(
    modifier: Modifier,
    pageState: Int,
) {

    val paddingBottom by animateDpAsState(
        targetValue = if (pageState == 0) 220.dp else 170.dp,
        animationSpec = tween(
            durationMillis = 400,
            easing = Ease
        ),
        label = "bottomPadding"
    )

    Column(
        modifier = modifier
            .padding(
                bottom = paddingBottom
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(40.dp)
    ) {

        AnimatedVisibility(
            visible = pageState >= 1,
            enter = fadeIn(),
            exit = ExitTransition.None
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                Text(
                    text = if (pageState == 1) "Начнем\nпутешествие"
                    else "У вас есть сила,\nчтобы",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    fontSize = 34.sp,
                    color = ButtonWhite
                )

                Text(
                    text = if (pageState == 1)"Умная, великолепная и модная\nколлекция Изучите сейчас"
                    else "В вашей комнате много красивых и\nпривлекательных растений",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    color = ButtonWhite
                )
            }
        }

        PageIndicator(
            pageState = pageState
        )
    }
}