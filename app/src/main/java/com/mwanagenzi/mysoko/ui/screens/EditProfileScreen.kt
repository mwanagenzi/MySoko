package com.mwanagenzi.mysoko.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mwanagenzi.mysoko.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfileScreen(modifier: Modifier, onSaveBtnPressed: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(
                    text = "Edit Profile",
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                    modifier = modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }, actions = {
                IconButton(onClick = {
                    //todo: show snackbar
                }, enabled = true) {
                    Icon(
                        imageVector = Icons.Outlined.Settings,
                        contentDescription = "App settings"
                    )
                }
            })
        }
    ) {
        Column(
            modifier = modifier
                .padding(it)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ProfileCard(modifier)
            //todo: change the below card to collection of edit texts
            ProfileTextFields(modifier = modifier, onButtonClick = onSaveBtnPressed)
        }
    }
}

@Composable
private fun ProfileCard(modifier: Modifier) {
    ElevatedCard(modifier = modifier.padding(horizontal = 16.dp)) {
        Row(
            modifier = modifier
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.basket),
                contentDescription = "Profile image",
                modifier = modifier
                    .size(65.dp)
                    .background(
                        color = Color.Transparent,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .weight(1f)
            )
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.Start,
                modifier = modifier.weight(3f)
            ) {
                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text("John Doe", style = MaterialTheme.typography.bodyLarge)
                    Spacer(modifier = modifier.size(4.dp))
                    Text("San Fransisco, CA", style = MaterialTheme.typography.bodySmall)
                }
                Spacer(modifier = modifier.size(16.dp))
                OutlinedButton(
                    onClick = {
                    //todo: navigate to edit profile screen
                }) {
                    Text(
                        text = "Delete",
                        style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold)
                    )
                }
            }
        }
    }
}

@Composable
private fun ProfileTextFields(modifier: Modifier, onButtonClick: () -> Unit) {
    Surface(
        shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
        color = Color.White,
        modifier = modifier.padding(horizontal = 16.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.fillMaxSize()
        ) {
            ProfileTextField(textFieldIcon = Icons.Outlined.Mail, textFieldName = "Email Address")
            ProfileTextField(textFieldIcon = Icons.Outlined.Person, textFieldName = "Username")
            ProfileTextField(textFieldIcon = Icons.Outlined.Home, textFieldName = "Address")
            ProfileTextField(textFieldIcon = Icons.Outlined.Call, textFieldName = "Mobile number")
            Spacer(modifier = modifier.size(8.dp))
            TextButton(
                onClick = onButtonClick,
                colors = ButtonDefaults.textButtonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = Color.White
                ),
                modifier = modifier.fillMaxWidth(),
            ) {
                Text(
                    text = "Save",
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Normal)
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ProfileTextField(textFieldIcon: ImageVector, textFieldName: String) {
    var textFieldText by remember {
        mutableStateOf(TextFieldValue(""))
    }
    OutlinedTextField(
        value = textFieldText,
        onValueChange = {
            textFieldText = it
        },
        leadingIcon = {
            Icon(
                imageVector = textFieldIcon,
                contentDescription = "$textFieldName icon"
            )
        },
        label = { Text(text = textFieldName) },
        placeholder = { Text(text = "Enter $textFieldName") },
    )

}

@Preview(showBackground = true, widthDp = 320, heightDp = 720)
@Composable
fun EditProfileScreenPreview() {
    EditProfileScreen(modifier = Modifier, onSaveBtnPressed = {})
}
