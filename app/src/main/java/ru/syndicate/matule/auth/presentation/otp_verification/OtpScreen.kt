package ru.syndicate.matule.auth.presentation.otp_verification

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getViewModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import ru.syndicate.matule.auth.presentation.components.BackButton
import ru.syndicate.matule.auth.presentation.otp_verification.components.OtpTextField
import ru.syndicate.matule.auth.view_model.AuthEvent
import ru.syndicate.matule.auth.view_model.AuthViewModel
import ru.syndicate.matule.ui.theme.CustomGray
import ru.syndicate.matule.ui.theme.CustomLightGray
import ru.syndicate.matule.ui.theme.TextBlack

class OtpScreen : Screen {

    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow

        val viewModel = getViewModel<AuthViewModel>()

        val otpText by viewModel.optText.collectAsState()

        OtpScreenContent(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .padding(
                    horizontal = 20.dp
                ),
            otpText = otpText,
            onChangeOtp = { if (it.length <= 6) viewModel.onEvent(AuthEvent.ChangeOTP(it)) },
            onClickBack = { navigator.pop() }
        )
    }
}

@Composable
fun OtpScreenContent(
    modifier: Modifier = Modifier,
    otpText: String = "",
    onChangeOtp: (String) -> Unit = { },
    onClickBack: () -> Unit = { }
) {

    Column(
        modifier = modifier
    ) {

        BackButton(
            modifier = Modifier
                .padding(
                    top = 23.dp
                )
                .clip(CircleShape)
                .background(
                    color = CustomLightGray
                )
                .clickable { onClickBack() }
                .padding(10.dp)
        )

        Spacer(
            modifier = Modifier
                .height(11.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            Text(
                text = "OTP проверка",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
                color = TextBlack
            )

            Text(
                text = "Пожалуйста, проверьте свою электронную почту, чтобы увидеть код подтверждения",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                color = CustomGray
            )
        }

        Spacer(
            modifier = Modifier
                .height(16.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            Text(
                text = "OTP Код",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.SemiBold,
                fontSize = 21.sp,
                color = TextBlack
            )

            OtpTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = otpText,
                onValueChange = onChangeOtp
            )
        }
    }
}

@Preview
@Composable
private fun PreviewOtpScreen() {
    OtpScreenContent(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White
            )
            .padding(
                horizontal = 20.dp
            )
    )
}