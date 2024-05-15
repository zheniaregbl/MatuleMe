package ru.syndicate.matule.auth.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.syndicate.matule.R
import ru.syndicate.matule.ui.theme.CustomBlue
import ru.syndicate.matule.ui.theme.CustomDarkGray
import ru.syndicate.matule.ui.theme.CustomLightGray

@Composable
fun AuthTextField(
    modifier: Modifier = Modifier,
    isPassword: Boolean = false,
    isEmail: Boolean = false,
    value: String = "",
    onValueChange: (String) -> Unit = { },
    hintText: String = "Текст"
) {

    var visible by remember {
        mutableStateOf(false)
    }

    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        textStyle = TextStyle(
            fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            color = CustomDarkGray
        ),
        singleLine = true,
        visualTransformation = if (isPassword && !visible) PasswordVisualTransformation()
            else VisualTransformation.None,
        cursorBrush = SolidColor(CustomBlue),
        keyboardOptions = KeyboardOptions(
            keyboardType = when {
                isEmail -> KeyboardType.Email
                isPassword -> KeyboardType.Password
                else -> KeyboardType.Text
            }
        )
    ) { innerTextField ->  
        
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(
                        end = if (isPassword) 6.dp else 0.dp
                    )
            ) {

                if (value.isEmpty()) {

                    Text(
                        text = hintText,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        color = CustomDarkGray.copy(alpha = 0.6f)
                    )
                }

                innerTextField()
            }

            if (isPassword) {

                Icon(
                    modifier = Modifier
                        .size(22.dp)
                        .clickable(
                            indication = null,
                            interactionSource = MutableInteractionSource()
                        ) { visible = !visible },
                    imageVector = ImageVector.vectorResource(
                        id = if (visible) R.drawable.svg_hide_pwd else R.drawable.svg_show_pwd
                    ),
                    contentDescription = null,
                    tint = CustomDarkGray
                )
            }
        }
    }
}

@Preview
@Composable
private fun PreviewAuthTextField() {
    AuthTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clip(RoundedCornerShape(14.dp))
            .background(
                color = CustomLightGray
            )
            .padding(
                horizontal = 14.dp,
                vertical = 16.dp
            )
    )
}