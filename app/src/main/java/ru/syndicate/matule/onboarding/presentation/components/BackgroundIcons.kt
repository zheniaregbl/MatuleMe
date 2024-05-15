package ru.syndicate.matule.onboarding.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.syndicate.matule.R
import ru.syndicate.matule.ui.theme.BackgroundGradient

@Composable
fun BackgroundIcons(
    modifier: Modifier = Modifier,
    pageState: Int = 2
) {

    Box(
        modifier = modifier
    ) {

        AnimatedVisibility(
            modifier = Modifier
                .fillMaxSize(),
            visible = pageState == 0,
            enter = fadeIn(),
            exit = fadeOut()
        ) {

            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {

                Icon(
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .padding(
                            top = 65.dp
                        ),
                    imageVector = ImageVector.vectorResource(id = R.drawable.svg_welcome_text),
                    contentDescription = null,
                    tint = Color.White
                )

                Icon(
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .alpha(0.4f)
                        .padding(
                            start = 45.dp,
                            bottom = 120.dp
                        ),
                    imageVector = ImageVector.vectorResource(id = R.drawable.svg_smile),
                    contentDescription = null,
                    tint = Color.White
                )

                Icon(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .alpha(0.4f)
                        .padding(
                            start = 30.dp,
                            bottom = 100.dp
                        ),
                    imageVector = ImageVector.vectorResource(id = R.drawable.svg_print),
                    contentDescription = null,
                    tint = Color.White
                )

                Icon(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .alpha(0.4f)
                        .padding(
                            end = 30.dp,
                            bottom = 165.dp
                        ),
                    imageVector = ImageVector.vectorResource(id = R.drawable.svg_print2),
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }

        AnimatedVisibility(
            modifier = Modifier
                .fillMaxSize(),
            visible = pageState == 1,
            enter = fadeIn(),
            exit = fadeOut()
        ) {

            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {

                Icon(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(
                            top = 70.dp,
                            end = 26.dp
                        )
                        .alpha(0.7f),
                    imageVector = ImageVector.vectorResource(id = R.drawable.svg_smile),
                    contentDescription = null,
                    tint = Color.White
                )

                Icon(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(
                            top = 73.dp,
                            start = 27.dp
                        )
                        .alpha(0.8f),
                    imageVector = ImageVector.vectorResource(id = R.drawable.svg_print2),
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }

        AnimatedVisibility(
            modifier = Modifier
                .fillMaxSize(),
            visible = pageState == 2,
            enter = fadeIn(),
            exit = fadeOut()
        ) {

            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {

                Icon(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(
                            top = 65.dp,
                            start = 52.dp
                        )
                        .size(77.dp)
                        .alpha(0.7f),
                    imageVector = ImageVector.vectorResource(id = R.drawable.svg_smile),
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }
    }
}

@Preview
@Composable
private fun PreviewBackgroundIcons() {
    BackgroundIcons(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = BackgroundGradient
                )
            )
    )
}