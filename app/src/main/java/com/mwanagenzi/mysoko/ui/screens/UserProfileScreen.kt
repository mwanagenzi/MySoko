package com.mwanagenzi.mysoko.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.outlined.AccountBalanceWallet
import androidx.compose.material.icons.outlined.Map
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
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
            ProfileCard(modifier)
        }
    }
}

@Composable
private fun ProfileCard(modifier: Modifier) {
    ElevatedCard(modifier = modifier) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
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
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("John Doe", style = MaterialTheme.typography.bodyLarge)
                    Spacer(modifier = modifier.size(4.dp))
                    Text("San Fransisco, CA", style = MaterialTheme.typography.bodySmall)
                }
                Spacer(modifier = modifier.size(16.dp))
                OutlinedButton(onClick = {
                    //todo: navigate to edit profile screen
                }) {
                    Text(
                        text = "Edit profile",
                        style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold)
                    )
                }
            }
        }
    }
}

@Composable
fun OrdersAndAddressInfo(modifier: Modifier) {
    Surface(
        shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
        color = Color.White,
        modifier = modifier.padding(horizontal = 16.dp)
    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "My Orders",
                style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Thin)
            )
            IconButton(onClick = {
                //todo: display snackbar view all orders tapped
            }) {
                Text(
                    text = "View All Orders",
                    style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Thin)
                )
                Icon(
                    imageVector = Icons.Filled.ArrowForwardIos,
                    contentDescription = "View All Orders"
                )
            }
        }
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.fillMaxWidth()
        ) {
            OrderOptionTile(modifier)
            OrderOptionTile(modifier)
            OrderOptionTile(modifier)
            OrderOptionTile(modifier)
            Spacer(modifier = modifier.size(8.dp))
            AddressText()
            AddressInfo(modifier)
            TextButton(
                onClick = {
                    //todo:logout
                }, colors = ButtonDefaults.textButtonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = "Log out",
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Normal)
                )
            }
        }
    }
}

@Composable
private fun AddressInfo(modifier: Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Icon(imageVector = Icons.Outlined.Map, contentDescription = "Address Icon")

        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "John Doe",
                style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Light)
            )
            Text(
                text = "7835 new road, Number 3 \n 12926-3874",
                style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Light)
            )
        }
    }
}

@Composable
private fun AddressText() {
    Text(
        text = "Address",
        style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Light)
    )
}

@Composable
private fun OrderOptionTile(modifier: Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                imageVector = Icons.Outlined.AccountBalanceWallet,
                contentDescription = "View orders to pay"
            )
            Spacer(modifier = modifier.size(12.dp))
            Text(
                text = "To Pay",
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium)
            )
        }

        Icon(imageVector = Icons.Filled.ArrowForwardIos, contentDescription = "To Pay")
    }
}


//@Preview()
//@Composable
//fun ProfileCardPreview() {
//    ProfileCard(modifier = Modifier)
//}
//@Preview(showBackground = true)
//@Composable
//fun OrderOptionTilePreview() {
//    OrderOptionTile(modifier = Modifier)
//}

