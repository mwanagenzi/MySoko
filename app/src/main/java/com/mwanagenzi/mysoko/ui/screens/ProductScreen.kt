package com.mwanagenzi.mysoko.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.StarRate
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.AssistChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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
fun ProductScreen(modifier: Modifier) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Outlined.Favorite,
                            contentDescription = "Favourite icon",
                            tint = Color.Red //todo: set this change if selected
                        )
                    }
                }
            )
        }
    ) {
        Column(
            modifier
                .fillMaxSize()
                .padding(it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.basket),
                contentDescription = "Product image",
                modifier.weight(1f)
            )
            Surface(
                modifier
                    .padding(horizontal = 16.dp)
                    .weight(1f),
                shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
            ) {
                Column(
                    modifier = modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Xbox Series X", style = MaterialTheme.typography.titleMedium)
                    Row {
                        AssistChip(onClick = {}, label = {
                            Row(horizontalArrangement = Arrangement.SpaceAround) {
                                Icon(
                                    imageVector = Icons.Filled.StarRate,
                                    contentDescription = "Rate product"
                                )
                                Text(text = "94%", style = MaterialTheme.typography.bodySmall)
                            }
                        })
                        Text(
                            text = "117 reviews",
                            style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Light)
                        )
                    }
                    Text(
                        dummyReview,
                        style = MaterialTheme.typography.bodySmall
                    )

                }

            }
        }
    }
}

const val dummyReview =
    "The Microsoft Xbox Series X gaming console is capable of impressing with minimal boot times and mesmerizing visual effects when playing games at up to 120 frames per second"