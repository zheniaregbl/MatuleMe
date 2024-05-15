package ru.syndicate.matule.auth.presentation.sign_up

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.style.TextDecoration
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
import ru.syndicate.matule.auth.view_model.AuthEvent
import ru.syndicate.matule.auth.view_model.AuthViewModel
import ru.syndicate.matule.auth.presentation.sign_up.components.SecureCheckBox
import ru.syndicate.matule.ui.theme.CustomBlue
import ru.syndicate.matule.ui.theme.CustomDarkGray
import ru.syndicate.matule.ui.theme.CustomGray
import ru.syndicate.matule.ui.theme.CustomLightGray
import ru.syndicate.matule.ui.theme.SecureTextGray
import ru.syndicate.matule.ui.theme.TextBlack

class SignUpScreen : Screen {

    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow

        val viewModel = getViewModel<AuthViewModel>()

        val emailText by viewModel.emailText.collectAsState()
        val passwordText by viewModel.passwordText.collectAsState()
        val nameText by viewModel.nameText.collectAsState()

        SignUpScreenContent(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .padding(
                    horizontal = 20.dp
                ),
            emailText = emailText,
            passwordText = passwordText,
            nameText = nameText,
            onChangeEmail = { viewModel.onEvent(AuthEvent.ChangeEmail(it)) },
            onChangePassword = { viewModel.onEvent(AuthEvent.ChangePassword(it)) },
            onChangeName = { viewModel.onEvent(AuthEvent.ChangeName(it)) },
            navigateToSignIn = { navigator.pop() },
            onClickBack = { navigator.pop() }
        )
    }
}

@Composable
fun SignUpScreenContent(
    modifier: Modifier = Modifier,
    emailText: String = "",
    passwordText: String = "",
    nameText: String = "",
    onChangeEmail: (String) -> Unit = { },
    onChangePassword: (String) -> Unit = { },
    onChangeName: (String) -> Unit = { },
    navigateToSignIn: () -> Unit = { },
    onClickBack: () -> Unit = { }
) {

    var isCheckSecure by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = modifier
    ) {

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .imePadding()
        ) {

            item {

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
            }

            item {
                Spacer(
                    modifier = Modifier
                        .height(11.dp)
                )
            }

            item {

                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    Text(
                        text = "Регистрация",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold,
                        fontSize = 32.sp,
                        color = TextBlack
                    )

                    Text(
                        text = "Заполните cвои данные или\nпродолжите через социальные медиа",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Center,
                        fontSize = 16.sp,
                        color = CustomGray
                    )
                }
            }

            item {
                Spacer(
                    modifier = Modifier
                        .height(30.dp)
                )
            }

            item {

                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    Text(
                        text = "Ваше имя",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp,
                        color = TextBlack
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
                        value = nameText,
                        onValueChange = onChangeName,
                        hintText = "Ваше имя",
                        isEmail = false,
                        isPassword = false
                    )
                }
            }

            item {
                Spacer(
                    modifier = Modifier
                        .height(12.dp)
                )
            }

            item {

                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    Text(
                        text = "Email",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp,
                        color = TextBlack
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
                }
            }

            item {
                Spacer(
                    modifier = Modifier
                        .height(30.dp)
                )
            }

            item {

                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    Text(
                        text = "Пароль",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp,
                        color = TextBlack
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
                        value = passwordText,
                        onValueChange = onChangePassword,
                        hintText = "Пароль",
                        isEmail = false,
                        isPassword = true
                    )
                }
            }

            item {
                Spacer(
                    modifier = Modifier
                        .height(8.dp)
                )
            }

            item {

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    SecureCheckBox(
                        modifier = Modifier
                            .clip(RoundedCornerShape(6.dp))
                            .size(18.dp)
                            .background(
                                color = CustomLightGray
                            )
                            .clickable { isCheckSecure = !isCheckSecure },
                        isCheck = isCheckSecure
                    )

                    Text(
                        text = "Даю согласие на обработку\nперсональных данных",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Medium,
                        textDecoration = TextDecoration.Underline,
                        lineHeight = 20.sp,
                        fontSize = 16.sp,
                        color = SecureTextGray
                    )
                }
            }

            item {
                Spacer(
                    modifier = Modifier
                        .height(12.dp)
                )
            }

            item {
                ConfirmButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(14.dp))
                        .background(
                            color = CustomBlue
                        )
                        .height(50.dp)
                        .clickable { },
                    text = "Зарегистрироваться"
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .navigationBarsPadding()
                .padding(
                    bottom = 4.dp
                )
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "Есть аккаунт?",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                color = CustomDarkGray
            )

            Spacer(
                modifier = Modifier
                    .width(3.dp)
            )

            Text(
                modifier = Modifier
                    .clickable(
                        indication = null,
                        interactionSource = MutableInteractionSource()
                    ) { navigateToSignIn() },
                text = "Войти",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                color = TextBlack
            )
        }
    }
}

@Preview
@Composable
private fun PreviewSignUpScreen() {
    SignUpScreenContent(
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