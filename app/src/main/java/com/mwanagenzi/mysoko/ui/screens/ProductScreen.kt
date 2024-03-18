package com.mwanagenzi.mysoko.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.StarRate
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
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
    ) { innerPadding ->
        Column(
            modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.basket),
                contentDescription = "Product image",
                modifier
                    .weight(1f)
                    .fillMaxWidth()
            )
            Surface(
                modifier
                    .weight(1f),
                shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
            ) {
                Column(
                    modifier = modifier
                        .fillMaxSize()
                        .padding(top = 8.dp),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Xbox Series X",
                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
                    )
                    Row(
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        AssistChip(onClick = {}, leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.StarRate,
                                contentDescription = "Product rating", tint = Color.Yellow
                            )
                        }, label = {
                                Text(text = "4.8", style = MaterialTheme.typography.bodySmall)
                            }
                        )
                        AssistChip(
                            onClick = {},
                            modifier = modifier.padding(horizontal = 10.dp),
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Filled.ThumbUp,
                                    contentDescription = "Product review"
                                )
                            },
                            label = {
                                Text(text = "94%", style = MaterialTheme.typography.bodySmall)
                            })
                        Text(
                            text = "117 reviews",
                            style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Normal)
                        )
                    }
                    Text(
                        dummyReview,
                        style = MaterialTheme.typography.bodySmall
                    )
                    Row(
                        modifier = modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        SuggestionChip(
                            onClick = {},
                            label = { Text(text = "1 TB", color = Color.White) },
                            colors = SuggestionChipDefaults.suggestionChipColors(containerColor = MaterialTheme.colorScheme.primary)
                        )
                        SuggestionChip(onClick = {}, label = { Text(text = "825 GB") })
                        SuggestionChip(onClick = {}, label = { Text(text = "256 GB") })
                    }
                    Spacer(modifier = modifier.height(8.dp))
                    Divider(color = Color.LightGray, thickness = Dp.Hairline)
                    Row(
                        modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Column(
                            horizontalAlignment = Alignment.Start
                        ) {
                            Text(
                                text = "$650.00",
                                style = MaterialTheme.typography.labelMedium.copy(
                                    textDecoration = TextDecoration.LineThrough,
                                    color = Color.Gray
                                )
                            )
                            Text(
                                text = "$570.00",
                                style = MaterialTheme.typography.titleMedium
                            )
                        }
                        Button(
                            onClick = {},
                            shape = RoundedCornerShape(20.dp),
                            contentPadding = PaddingValues(horizontal = 32.dp)
                        ) {
                            Text(text = "Add to Cart")
                        }
                    }
                }
            }
        }
    }
}

const val dummyReview =
    "The Microsoft Xbox Series X gaming console is capable of impressing with minimal boot times and mesmerizing visual effects when playing games at up to 120 frames per second"

@Preview(showBackground = true, widthDp = 320, heightDp = 720)
@Composable
fun ProductScreenPreview() {
    ProductScreen(modifier = Modifier)
}