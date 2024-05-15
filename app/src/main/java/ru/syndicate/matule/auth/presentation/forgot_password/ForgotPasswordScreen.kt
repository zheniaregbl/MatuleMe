package ru.syndicate.matule.auth.presentation.forgot_password

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import ru.syndicate.matule.auth.presentation.components.AuthTextField
import ru.syndicate.matule.auth.presentation.components.BackButton
import ru.syndicate.matule.auth.presentation.components.ConfirmButton
import ru.syndicate.matule.auth.presentation.forgot_password.components.CheckEmailDialog
import ru.syndicate.matule.auth.presentation.otp_verification.OtpScreen
import ru.syndicate.matule.auth.view_model.AuthEvent
import ru.syndicate.matule.auth.view_model.AuthViewModel
import ru.syndicate.matule.ui.theme.CustomBlue
import ru.syndicate.matule.ui.theme.CustomGray
import ru.syndicate.matule.ui.theme.CustomLightGray
import ru.syndicate.matule.ui.theme.TextBlack
import ru.syndicate.matule.ui.utils.safePush

class ForgotPasswordScreen : Screen {

    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow

        val viewModel = getViewModel<AuthViewModel>()

        val emailText by viewModel.emailText.collectAsState()

        ForgotPasswordScreenContent(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .padding(
                    horizontal = 20.dp
                ),
            emailText = emailText,
            onChangeEmail = { viewModel.onEvent(AuthEvent.ChangeEmail(it)) },
            navigateToOTP = { navigator.safePush(OtpScreen()) },
            onClickBack = { navigator.pop() }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForgotPasswordScreenContent(
    modifier: Modifier = Modifier,
    emailText: String = "",
    onChangeEmail: (String) -> Unit = { },
    navigateToOTP: () -> Unit = { },
    onClickBack: () -> Unit = { }
) {

    var showDialog by remember {
        mutableStateOf(false)
    }

    if (showDialog) {

        BasicAlertDialog(
            modifier = Modifier
                .fillMaxWidth(),
            onDismissRequest = { showDialog = false }
        ) {

            CheckEmailDialog(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        color = Color.White
                    )
            )
        }
    }

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
                text = "Забыл пароль",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
                color = TextBlack
            )

            Text(
                text = "Введите свою учетную запись\nдля сброса",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                color = CustomGray
            )
        }

        Spacer(
            modifier = Modifier
                .height(40.dp)
        )

        AuthTextField(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(14.dp))
                .background(
                    color = CustomLightGray
                )
                .padding(
                    horizontal = 14.dp,
                    vertical = 16.dp
                ),
            value = emailText,
            onValueChange = onChangeEmail,
            hintText = "Email",
            isEmail = true,
            isPassword = false
        )

        Spacer(
            modifier = Modifier
                .height(40.dp)
        )

        ConfirmButton(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(14.dp))
                .background(
                    color = CustomBlue
                )
                .height(50.dp)
                .clickable {
                    if (emailText.isNotEmpty())
                        navigateToOTP()
                    else
                        showDialog = true
                },
            text = "Отправить"
        )
    }
}

@Preview
@Composable
private fun PreviewForgotPasswordScreen() {
    ForgotPasswordScreenContent(
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