package com.mwanagenzi.mysoko.ui.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
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
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(it)
        ) {
            AppLogo(appLogoDrawable = R.drawable.basket)
            AppName()
            LoginButton(modifier = modifier)
            SignUpButton(modifier)
        }
    }
}

@Composable
private fun LoginButton(modifier: Modifier) {
    Button(onClick = {}, shape = RoundedCornerShape(20.dp), modifier = modifier) {
        Text("Continue")
    }
}

@Composable
private fun SignUpButton(modifier: Modifier) {
    OutlinedButton(onClick = {}, shape = RoundedCornerShape(20.dp)) {
        Text(text = "Agree & Continue")
    }
}

@Composable
private fun AppName(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(id = R.string.app_name),
        modifier = modifier,
        style = TextStyle(fontWeight = FontWeight.Medium, fontFamily = FontFamily.SansSerif)
    )
}

@Composable
private fun AppLogo(
    @DrawableRes appLogoDrawable: Int
) {
    Image(
        painter = painterResource(id = appLogoDrawable),
        contentDescription = "App Logo",
        modifier = Modifier.size(100.dp)
    )
}