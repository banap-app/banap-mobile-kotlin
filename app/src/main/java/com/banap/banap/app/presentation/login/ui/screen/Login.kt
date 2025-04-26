package com.banap.banap.app.presentation.login.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.banap.banap.R
import com.banap.banap.domain.viewmodel.LoginViewModel
import com.banap.banap.core.ui.components.Button
import com.banap.banap.app.presentation.login.ui.components.TextBox
import com.banap.banap.app.presentation.session.viewmodel.TokenViewModel
import com.banap.banap.core.ui.util.setColorInText
import com.banap.banap.core.ui.theme.BRANCO
import com.banap.banap.core.ui.theme.PRETO
import com.banap.banap.core.ui.theme.ShapeLogin
import com.banap.banap.core.ui.theme.Typography
import com.banap.banap.core.ui.theme.VERDE_CLARO
import com.banap.banap.core.ui.theme.VERDE_ESCURO
import com.banap.banap.core.ui.theme.VERMELHO
import com.banap.banap.app.presentation.validation.email.event.EmailTextFieldFormEvent
import com.banap.banap.app.presentation.validation.email.viewmodel.EmailTextFieldViewModel
import com.banap.banap.app.presentation.validation.password.event.PasswordTextFieldFormEvent
import com.banap.banap.app.presentation.validation.password.viewmodel.PasswordTextFieldViewModel
import com.banap.banap.app.presentation.validation.email.utils.validationDataEmail
import com.banap.banap.app.presentation.validation.password.utils.validationDataPassword

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Login(
    navigationController: NavController,
    loginViewModel: LoginViewModel = hiltViewModel(),
    tokenViewModel: TokenViewModel
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        containerColor = BRANCO
    ) {
        val context = LocalContext.current

        val loginState = loginViewModel.state.value

        var isCredentialsCorrect: Boolean? by remember {
            mutableStateOf(null)
        }

        LaunchedEffect(loginState.response) {
            loginState.response?.token?.let { token ->
                tokenViewModel.saveToken(token)

                if (tokenViewModel.getToken() != null) {
                    navigationController.navigate("home")
                }
            }
        }

        LaunchedEffect(loginState.error) {
            if (loginState.error.isNotBlank()) {
                isCredentialsCorrect = false
            }
        }

        val viewModelEmail = viewModel<EmailTextFieldViewModel>()
        val stateEmail = viewModelEmail.state

        val viewModelPassword = viewModel<PasswordTextFieldViewModel>()
        val statePassword = viewModelPassword.state

        val validationDataEmail = validationDataEmail(
            context = context,
            viewModelEmail = viewModelEmail,
            stateEmail = stateEmail
        )

        val validationDataPassword = validationDataPassword(
            context = context,
            viewModelPassword = viewModelPassword,
            statePassword = statePassword
        )

        val isValidationSuccessful = validationDataEmail && validationDataPassword

        val screenWidth = LocalConfiguration.current.screenWidthDp.dp
        val screenHeight = LocalConfiguration.current.screenHeightDp.dp

        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.desenho_de_cima),
            contentDescription = "Vetor de linhas",
            modifier = Modifier
                .absoluteOffset(
                    x = screenWidth - 150.dp,
                    y = 0.dp
                )
                .scale(1.2F)
        )

        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.circulos_cima),
            contentDescription = "Desenhos de esferas verdes",
            modifier = Modifier
                .absoluteOffset(
                    x = screenWidth - 130.dp,
                    y = 195.dp
                )
                .scale(0.9F)
        )

        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.banap),
                contentDescription = "Logo do Banap",
                modifier = Modifier
                    .scale(0.9F)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Entre com sua\n conta!",
                textAlign = TextAlign.Center,
                style = Typography.titleSmall,
                color = VERDE_ESCURO
            )

            Spacer(modifier = Modifier.height(40.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 70.dp)
            ) {
                Column {
                    TextBox(
                        value = stateEmail.email,
                        onValueChange = {
                            viewModelEmail.onEvent(EmailTextFieldFormEvent.EmailChanged(it))
                            viewModelEmail.onEvent(EmailTextFieldFormEvent.Submit)
                        },
                        modifier = Modifier
                            .onFocusChanged {
                                if (it.isFocused) {
                                    isCredentialsCorrect = null
                                }
                            }
                            .fillMaxWidth(),
                        maxLines = 1,
                        keyboardType = KeyboardType.Email,
                        icon = R.drawable.email,
                        iconColor = PRETO,
                        placeholder = "email@gmail.com",
                        passwordTextBox = false,
                        label = "Email",
                        labelTextStyle = Typography.labelSmall,
                        labelColor = PRETO,
                        isError = stateEmail.emailError != null || isCredentialsCorrect == false
                    )

                    if (stateEmail.emailError != null || isCredentialsCorrect == false) {
                        Text(
                            text = stateEmail.emailError ?: "O email está incorreto",
                            color = VERMELHO,
                            style = Typography.displaySmall
                        )
                    }

                    Spacer(modifier = Modifier.height(30.dp))

                    TextBox(
                        value = statePassword.password,
                        onValueChange = {
                            viewModelPassword.onEvent(PasswordTextFieldFormEvent.PasswordChanged(it))
                            viewModelPassword.onEvent(PasswordTextFieldFormEvent.Submit)
                        },
                        modifier = Modifier
                            .fillMaxWidth(),
                        maxLines = 1,
                        keyboardType = KeyboardType.Password,
                        icon = R.drawable.lock,
                        iconColor = PRETO,
                        placeholder = "Senha123",
                        passwordTextBox = true,
                        label = "Senha",
                        labelTextStyle = Typography.labelSmall,
                        labelColor = PRETO,
                        isError = statePassword.passwordError != null || isCredentialsCorrect == false,
                        lastOne = true
                    )

                    if (statePassword.passwordError != null || isCredentialsCorrect == false) {
                        Text(
                            text = statePassword.passwordError ?: "A senha está incorreta",
                            color = VERMELHO,
                            style = Typography.displaySmall
                        )
                    }

                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = "Esqueceu sua senha?",
                        textAlign = TextAlign.End,
                        style = Typography.bodySmall,
                        fontWeight = FontWeight.Medium,
                        color = VERDE_ESCURO,
                        modifier = Modifier
                            .fillMaxWidth(),
                    )

                    Spacer(modifier = Modifier.height(15.dp))

                    Button(
                        texto = "Entrar",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 12.dp),
                        icon = false,
                        shape = ShapeLogin.small,
                        onClick = {
                            viewModelEmail.onEvent(EmailTextFieldFormEvent.Submit)
                            viewModelPassword.onEvent(PasswordTextFieldFormEvent.Submit)

                            if (isValidationSuccessful) {
                                loginViewModel.authenticateUser(stateEmail.email, statePassword.password)
                            }
                        },
                        backgroundColor = VERDE_CLARO,
                        contentColor = BRANCO,
                        defaultElevetion = 3.dp
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = setColorInText(
                            texto = "Não possui uma conta? ",
                            textoASerDestacado = "Crie uma.",
                            fontWeight = FontWeight.Medium,
                            fontSize = 14.sp,
                            corEmDestaque = VERDE_ESCURO,
                            ordemInversa = false,
                            useLink = true,
                            navigationController = navigationController
                        ),
                        textAlign = TextAlign.Center,
                        style = Typography.bodySmall,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }
            }
        }

        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.circulos_baixo),
            contentDescription = "Desenhos de esferas verdes",
            modifier = Modifier
                .absoluteOffset(
                    x = 50.dp,
                    y = screenHeight - 175.dp
                )
                .scale(0.9F)
        )

        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.desenho_de_baixo),
            contentDescription = "Vetor de linhas",
            modifier = Modifier
                .absoluteOffset(
                    x = 0.dp,
                    y = screenHeight - 150.dp
                )
                .scale(1.2F)
        )
    }
}