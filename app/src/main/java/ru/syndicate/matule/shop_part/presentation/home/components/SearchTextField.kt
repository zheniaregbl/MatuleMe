package ru.syndicate.matule.shop_part.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.syndicate.matule.R
import ru.syndicate.matule.ui.theme.CustomBlue
import ru.syndicate.matule.ui.theme.CustomDarkGray
import ru.syndicate.matule.ui.theme.CustomGray

@Composable
fun SearchTextField(
    modifier: Modifier = Modifier,
    value: String = "",
    onValueChange: (String) -> Unit = { },
    hintText: String = "Поиск"
) {

    BasicTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        textStyle = TextStyle(
            fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp,
            color = CustomGray
        ),
        singleLine = true,
        visualTransformation = VisualTransformation.None,
        cursorBrush = SolidColor(CustomBlue),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text
        )
    ) { innerTextField ->  
        
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(14.dp))
                .background(
                    color = Color.White
                )
                .padding(
                    horizontal = 26.dp,
                    vertical = 14.dp
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.svg_search),
                contentDescription = null
            )

            Spacer(
                modifier = Modifier
                    .width(12.dp)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {

                if (value.isEmpty()) {

                    Text(
                        text = hintText,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Medium,
                        fontSize = 12.sp,
                        color = CustomDarkGray.copy(alpha = 0.6f)
                    )
                }

                innerTextField()
            }
        }
    }
}

@Preview
@Composable
private fun PreviewSearchTextField() {
    SearchTextField(
        modifier = Modifier
    )
}