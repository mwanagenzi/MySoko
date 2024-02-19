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
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mwanagenzi.mysoko.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserProfileScreen(modifier: Modifier) {
    //header
    //profile card
    //my orders container
    //address card
    //logout button

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(
                    text = "Profile",
                    style = MaterialTheme.typography.bodyMedium
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
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ElevatedCard(modifier = modifier) {
                Row(modifier = modifier.fillMaxWidth()) {
                    Image(
                        painter = painterResource(id = R.drawable.basket),
                        contentDescription = "Profile image",
                        modifier = modifier
                            .size(65.dp)
                            .background(
                                color = Color.Transparent,
                                shape = RoundedCornerShape(10.dp)
                            )
                    )
                    Column(
                        modifier = modifier.fillMaxHeight(),
                        verticalArrangement = Arrangement.SpaceBetween,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Column(
                            verticalArrangement = Arrangement.Top,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text("John Doe", style = MaterialTheme.typography.bodyLarge)
                            Spacer(modifier = modifier.size(8.dp))
                            Text("San Fransisco, CA", style = MaterialTheme.typography.bodySmall)
                        }
                    }
                }
            }
        }
    }
}

