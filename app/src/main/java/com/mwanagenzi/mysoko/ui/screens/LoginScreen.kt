@file:OptIn(ExperimentalMaterial3Api::class)

package com.mwanagenzi.mysoko.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(modifier: Modifier) {
    Scaffold() {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(it)
        ) {
            Text(
                text = "Log In",
                style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Medium)
            )
            Surface(
                shape = RoundedCornerShape(20.dp),
                color = Color.LightGray,
                modifier = modifier.padding(horizontal = 18.dp)
            ) {
                PasswordTextField(modifier = modifier)
                LoginButton(modifier)
                ForgotPasswordLinkText(modifier)
            }
        }
    }
}

@Composable
private fun ForgotPasswordLinkText(modifier: Modifier) {
    Text(buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colorScheme.primary,
                fontSize = 16.sp
            )
        ) {
            append("Forgot your password?")
            addStringAnnotation(
                tag = "URL",
                annotation = "https://auth0.com/docs/customize/universal-login-pages/customize-password-reset-page",
                start = 1,
                end = 20
            )
        }
    }, modifier = modifier.clickable {
        //todo: navigate to forgot password screen or link in email
    })
}

@Composable
private fun LoginButton(modifier: Modifier) {
    Button(onClick = {}, shape = RoundedCornerShape(20.dp), modifier = modifier) {
        Text("Continue")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PasswordTextField(modifier: Modifier) {
    var password by rememberSaveable {
        mutableStateOf(TextFieldValue(""))
    }
    OutlinedTextField(
        value = password,
        onValueChange = {
            password = it
        },
        singleLine = true,
        label = { Text(text = "Password") },
        placeholder = { Text(text = "Enter Password") },
        leadingIcon = {
            Icon(imageVector = Icons.Outlined.Lock, contentDescription = "Password Icon")
        },
        trailingIcon = {
            Icon(imageVector = Icons.Outlined.Lock, contentDescription = "Password Visibility Icon", Modifier.clickable {
                //todo: change state of text from hidden to visible and vice versa
                //todo: import relevant trailing icon and also cater for its rendering changes
            })
        },
        modifier = modifier.padding(top = 18.dp)
    )
}