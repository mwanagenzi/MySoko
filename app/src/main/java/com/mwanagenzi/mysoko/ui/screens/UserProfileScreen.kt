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
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.outlined.AccountBalanceWallet
import androidx.compose.material.icons.outlined.ArrowForwardIos
import androidx.compose.material.icons.outlined.Backpack
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.LocalShipping
import androidx.compose.material.icons.outlined.Map
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Wallet
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mwanagenzi.mysoko.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserProfileScreen(modifier: Modifier) {
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(
                    text = "Profile",
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
            OrdersAndAddressInfo(modifier)
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
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.fillMaxSize()
        ) {
            MyOrdersInfo(modifier)
            OrderOptionTile(modifier, Icons.Outlined.AccountBalanceWallet, "To pay")
            OrderOptionTile(modifier, Icons.Outlined.LocalShipping, "To ship")
            OrderOptionTile(modifier, Icons.Outlined.Backpack, "To receive")
            OrderOptionTile(modifier, Icons.Outlined.FavoriteBorder, "Wishlist")
            Spacer(modifier = modifier.size(8.dp))
            AddressInfo(modifier)
            TextButton(
                onClick = {
                    //todo:logout
                },
                colors = ButtonDefaults.textButtonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = Color.White
                ),
                modifier = modifier.fillMaxWidth(),
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
private fun MyOrdersInfo(modifier: Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "My Orders",
            style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.SemiBold)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "View orders to pay",
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium)
            )
            Spacer(modifier = modifier.size(12.dp))
            Icon(
                imageVector = Icons.Outlined.ArrowForwardIos,
                contentDescription = "View orders to pay"
            )
        }
    }
}

@Composable
private fun AddressInfo(modifier: Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start
    ) {


        Text(
            text = "Address",
            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold),
            modifier = modifier.fillMaxWidth(),
            textAlign = TextAlign.Start
        )
        Spacer(modifier = modifier.size(10.dp))
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Icon(imageVector = Icons.Outlined.Map, contentDescription = "Address Icon")

            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "John Doe",
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold)
                )
                Text(
                    text = "7835 new road, Number 3 \n12926-3874",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}

@Composable
private fun OrderOptionTile(modifier: Modifier, tileIcon: ImageVector, tileName: String) {
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
                imageVector = tileIcon,
                contentDescription = "View orders to pay"
            )
            Spacer(modifier = modifier.size(12.dp))
            Text(
                text = tileName,
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium)
            )
        }

        Icon(imageVector = Icons.Filled.ArrowForwardIos, contentDescription = "To Pay")
    }
}

@Preview(showBackground = true, heightDp = 620, widthDp = 320)
@Composable
fun ProfileScreenPreview(){
    UserProfileScreen(modifier = Modifier)
}