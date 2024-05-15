package ru.syndicate.matule.auth.presentation.forgot_password.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.syndicate.matule.R
import ru.syndicate.matule.ui.theme.CustomBlue
import ru.syndicate.matule.ui.theme.CustomGray
import ru.syndicate.matule.ui.theme.TextBlack

@Composable
fun CheckEmailDialog(
    modifier: Modifier = Modifier
) {

    Surface(
        modifier = modifier
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 10.dp,
                    vertical = 30.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Icon(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(
                        color = CustomBlue
                    )
                    .padding(10.dp),
                imageVector = ImageVector.vectorResource(id = R.drawable.svg_email),
                contentDescription = null,
                tint = Color.White
            )

            Spacer(
                modifier = Modifier
                    .height(24.dp)
            )

            Text(
                text = "Проверьте Ваш Email",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = TextBlack
            )

            Spacer(
                modifier = Modifier
                    .height(8.dp)
            )

            Text(
                text = "Мы отправили код восстановления пароля на вашу электронную почту.",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                lineHeight = 20.sp,
                fontSize = 16.sp,
                color = CustomGray
            )
        }
    }
}

@Preview
@Composable
private fun PreviewCheckEmailDialog() {
    CheckEmailDialog(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(
                color = Color.White
            )
    )
}