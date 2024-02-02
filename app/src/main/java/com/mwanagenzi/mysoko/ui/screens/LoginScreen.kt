@file:OptIn(ExperimentalMaterial3Api::class)

package com.mwanagenzi.mysoko.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
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
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(modifier: Modifier) {
    //password text field
    //"Continue" button
    //Forgot your password link text
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
            }
        }
    }
}

@Composable
private fun PasswordTextField(modifier: Modifier) {
    var password by remember {
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
            Icon(imageVector = Icons.Outlined.Lock, contentDescription = "Password Visibility Icon")
        },
        modifier = modifier.padding(top = 18.dp)
    )
}