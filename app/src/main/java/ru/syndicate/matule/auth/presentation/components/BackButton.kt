package ru.syndicate.matule.auth.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import ru.syndicate.matule.R
import ru.syndicate.matule.ui.theme.TextBlack

@Composable
fun BackButton(
    modifier: Modifier = Modifier
) {

    Box(
        modifier = modifier
    ) {

        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.svg_back_arrow),
            contentDescription = null,
            tint = TextBlack
        )
    }
}