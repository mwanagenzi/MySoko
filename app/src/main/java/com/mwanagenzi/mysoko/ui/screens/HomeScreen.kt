package com.mwanagenzi.mysoko.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Percent
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mwanagenzi.mysoko.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(modifier: Modifier) {
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(
                    text = "Discover",
                    style = MaterialTheme.typography.bodyMedium
                )
            }, actions = {
                IconButton(onClick = {
                    // todo: Navigate to cart
                }, enabled = true) {
                    Icon(
                        imageVector = Icons.Outlined.ShoppingCart,
                        contentDescription = "Shopping Cart Icon"
                    )
                }
            })
        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(selected = true, onClick = {}, icon = {
                    Icon(
                        imageVector = Icons.Filled.Home,
                        contentDescription = "Home Tab"
                    )
                })
                NavigationBarItem(selected = true, onClick = {}, icon = {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Search Tab"
                    )
                })
                NavigationBarItem(selected = true, onClick = {}, icon = {
                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = "Favourite Tab"
                    )
                })
            }
        },
    ) { innerPadding ->
        Column(
            modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Surface(
                shape = RoundedCornerShape(20.dp),
                color = MaterialTheme.colorScheme.primary,
                shadowElevation = 10.dp,
            ) {
                Row(
                    modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        verticalArrangement = Arrangement.SpaceBetween,
                        horizontalAlignment = Alignment.Start,
                        modifier = modifier.weight(1f)
                    ) {
                        Text(
                            modifier = modifier,
                            text = "Clearance Sales",
                            style = MaterialTheme.typography.headlineSmall,
                            maxLines = 2,
                            textAlign = TextAlign.Start,
                            softWrap = true
                        )
                        AssistChip(
                            onClick = {},
                            label = {
                                Text(
                                    text = "Up to 50%",
                                    color = MaterialTheme.colorScheme.primary
                                )
                            },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Outlined.Percent,
                                    contentDescription = "Discount chip"
                                )
                            },
                            colors = AssistChipDefaults.assistChipColors(containerColor = Color.White)
                        )

                    }
                    Image(
                        painter = painterResource(id = R.drawable.basket),
                        contentDescription = "Sale Advert Image",
                        modifier
                            .weight(1f)
                            .padding(16.dp)
                    )
                }
            }
            Row(modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "Categories", style = MaterialTheme.typography.titleMedium)
                Text(
                    text = "See all",
                    color = MaterialTheme.colorScheme.primary,
                    modifier = modifier.clickable {},
                )
            }
            LazyRow(content = {
                items(10) {
                    AssistChip(onClick = {
                        //todo: filter content based on selected category
                    }, label = { Text("Category $it") })
                    Spacer(modifier = modifier.size(8.dp))
                }
            })
            LazyVerticalGrid(columns = GridCells.Fixed(2), content = {
                items(10) {
                    Card(modifier.size(100.dp)) {
                        Column(
                            verticalArrangement = Arrangement.SpaceBetween,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.basket),
                                contentDescription = "Product Card", modifier.size(50.dp)
                            )
                            Text("Name", style = MaterialTheme.typography.bodySmall)
                        }
                    }
                }
            })
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 720)
@Composable
fun PreviewHomeScreen() {
    HomeScreen(modifier = Modifier)
}
