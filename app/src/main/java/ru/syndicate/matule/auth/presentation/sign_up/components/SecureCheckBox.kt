package ru.syndicate.matule.auth.presentation.sign_up.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import ru.syndicate.matule.R
import ru.syndicate.matule.ui.theme.TextBlack

@Composable
fun SecureCheckBox(
    modifier: Modifier = Modifier,
    isCheck: Boolean = false
) {

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {

        if (isCheck) {

            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.svg_secure),
                contentDescription = null,
                tint = TextBlack
            )
        }
    }
}