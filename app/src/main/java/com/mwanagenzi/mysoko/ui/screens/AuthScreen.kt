package com.mwanagenzi.mysoko.ui.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.mwanagenzi.mysoko.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthScreen(modifier: Modifier, onLoginButtonClicked: () -> Unit,onSignUpButtonClicked: () -> Unit) {
    Scaffold() {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
                .padding(it)
        ) {
            AppLogo(appLogoDrawable = R.drawable.basket)
            AppName()
            Spacer(modifier = Modifier.height(18.dp))
            LoginButton(modifier = modifier, onButtonClicked = onLoginButtonClicked)
            SignUpButton(modifier, onSignUpButtonClicked)
        }
    }
}

@Composable
private fun LoginButton(modifier: Modifier, onButtonClicked: () -> Unit) {
    Button(onClick = onButtonClicked, shape = RoundedCornerShape(20.dp), contentPadding = PaddingValues(horizontal = 96.dp)) {
        Text("Login")
    }
}

@Composable
private fun SignUpButton(modifier: Modifier, onButtonClicked: () -> Unit) {
    OutlinedButton(onClick = onButtonClicked, shape = RoundedCornerShape(20.dp), contentPadding = PaddingValues(horizontal = 88.dp)) {
        Text(text = "Sign Up")
    }
}

@Composable
private fun AppName(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(id = R.string.app_name),
        modifier = modifier,
        style = MaterialTheme.typography.titleLarge.copy(
            fontWeight = FontWeight.Medium,
            fontFamily = FontFamily.SansSerif
        )
    )
}

@Composable
private fun AppLogo(
    @DrawableRes appLogoDrawable: Int
) {
    Image(
        painter = painterResource(id = appLogoDrawable),
        contentDescription = "App Logo",
    )
}