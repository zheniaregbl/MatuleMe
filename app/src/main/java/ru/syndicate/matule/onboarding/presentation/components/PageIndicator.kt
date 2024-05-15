package ru.syndicate.matule.onboarding.presentation.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.syndicate.matule.ui.theme.DarkBlue

@Composable
fun PageIndicator(
    modifier: Modifier = Modifier,
    pageState: Int = 0,
    pageCount: Int = 3
) {

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        for (i in 0 until pageCount) {

            val width by animateDpAsState(
                targetValue = if (pageState == i) 42.dp else 28.dp,
                label = "width"
            )

            val color by animateColorAsState(
                targetValue = if (pageState == i) Color.White else DarkBlue,
                label = "color"
            )

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .height(5.dp)
                    .width(width)
                    .background(
                        color = color
                    )
            ) {

            }
        }
    }
}

@Preview
@Composable
private fun PreviewPageIndicator() {
    PageIndicator()
}