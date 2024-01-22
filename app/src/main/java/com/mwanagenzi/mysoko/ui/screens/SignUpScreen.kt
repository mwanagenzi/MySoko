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
import androidx.compose.material.icons.outlined.Person
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
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(modifier: Modifier) {

    Scaffold() {
        Column(
            modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Sign up",
                style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
                modifier = modifier.padding(bottom = 18.dp)
            )
            Surface(
                shape = RoundedCornerShape(20.dp),
                color = Color.LightGray
            ) {
                Column(
                    modifier = modifier
                        .padding(horizontal = 18.dp, vertical = 36.dp),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    UsernameTextField(modifier)
                    PasswordTextField(modifier)
                    PolicyAgreementClickableLinkText(modifier)
                    SignUpButton()
                }
            }
        }
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UsernameTextField(modifier: Modifier) {
    var usernameText by remember {
        mutableStateOf(TextFieldValue(""))
    }
    OutlinedTextField(
        value = usernameText,
        onValueChange = {
            usernameText = it
        },
//        modifier = modifier.padding(top = 18.dp),
        label = { Text(text = "Username") },
        singleLine = true,
        placeholder = { Text(text = "Enter Username") },
        leadingIcon = {
            Icon(imageVector = Icons.Outlined.Person, contentDescription = "Account name icon")
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextField(modifier: Modifier) {
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
        modifier = modifier.padding(top = 18.dp)
    )
}

@Composable
fun PolicyAgreementClickableLinkText(modifier: Modifier) {
    val uriHandler = LocalUriHandler.current

    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(color = Color.Red)) {
            append("Terms of Service and Privacy Policy")
        }
        addStringAnnotation(
            tag = "URL",
            annotation = "https://www.privacypolicies.com",
            start = 10,
            end = 18
        )
    }

    Text(
        text = "By selecting Agree and Continue, \n I agree to  $annotatedString",
        modifier = Modifier
            .padding(vertical = 18.dp)
            .clickable {
                annotatedString
                    .getStringAnnotations("URL", 10, 18)
                    .firstOrNull()
                    ?.let { annotation ->
                        uriHandler.openUri(annotation.item)
                    }
            }
    )
}

@Composable
fun SignUpButton() {
    Button(onClick = {}, shape = RoundedCornerShape(20.dp)) {
        Text(text = "Agree & Continue")
    }
}


@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    SignUpScreen(modifier = Modifier)
}
