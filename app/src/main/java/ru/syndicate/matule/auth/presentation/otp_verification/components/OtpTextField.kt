package ru.syndicate.matule.auth.presentation.otp_verification.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.syndicate.matule.ui.theme.CustomBlue
import ru.syndicate.matule.ui.theme.CustomLightGray
import ru.syndicate.matule.ui.theme.TextBlack

@Composable
fun OtpTextField(
    modifier: Modifier = Modifier,
    value: String = "",
    onValueChange: (String) -> Unit = { }
) {

    BasicTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        cursorBrush = SolidColor(CustomBlue),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.NumberPassword
        )
    ) {

        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            repeat(6) { index ->

                val number: String = when {
                    index >= value.length -> ""
                    else -> value[index].toString()
                }

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .size(
                            width = 46.dp,
                            height = 100.dp
                        )
                        .background(
                            color = CustomLightGray
                        ),
                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        text = number,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp,
                        color = TextBlack
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun PreviewOtpTextField() {
    OtpTextField(
        modifier = Modifier
    )
}