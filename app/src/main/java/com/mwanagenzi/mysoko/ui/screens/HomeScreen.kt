package com.mwanagenzi.mysoko.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Percent
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
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
                    style = MaterialTheme.typography.titleLarge
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
            NavigationBar() {

                NavigationBarItem(selected = true, onClick = {}, icon = {
                    Icon(
                        imageVector = Icons.Outlined.Home,
                        contentDescription = "Home Tab"
                    )
                }, label = {
                    Text(text = "Home")
                })
                NavigationBarItem(selected = true, onClick = {}, icon = {
                    Icon(
                        imageVector = Icons.Outlined.Search,
                        contentDescription = "Search Tab"
                    )
                }, label = {
                    Text(text = "Search")
                })
                NavigationBarItem(selected = true, onClick = {}, icon = {
                    Icon(
                        imageVector = Icons.Outlined.FavoriteBorder,
                        contentDescription = "Favourite Tab"
                    )
                }, label = {
                    Text(text = "Favourites")
                })
                NavigationBarItem(selected = true, onClick = {}, icon = {
                    Icon(
                        imageVector = Icons.Outlined.Person,
                        contentDescription = "Profile Tab"
                    )
                }, label = {
                    Text(text = "Profile")
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
            SearchBar()
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
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                content = {
                    items(10) { item ->
                        AssistChip(
                            colors = AssistChipDefaults.assistChipColors(
                                containerColor = if (item == 0) MaterialTheme.colorScheme.primary else
                                    Color.Transparent,
                            ),
                            onClick = {
                        //todo: filter content based on selected category
                            },
                            label = {
                                Text(
                                    "Category $item",
                                    color = if (item == 0) Color.White else Color.Black
                                )
                            })
                }
            })
            LazyVerticalGrid(columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                content = {
                items(10) {
                    ProductCard(modifier)
                }
            })
        }
    }
}

@Composable
private fun ProductCard(modifier: Modifier) {
    Surface(

    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalAlignment = Alignment.Start,
        ) {
            Image(
                painterResource(id = R.drawable.basket),
                contentDescription = "Product image",
                modifier
                    .background(color = Color.LightGray, shape = RoundedCornerShape(20.dp))
                    .padding(16.dp)
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Air Pods",
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.W400),
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,

                    ) {
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = "Product rating",
                        tint = Color.Yellow
                    )

                    Text(
                        text = "4.9",
                        style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
                    )
                }
            }
            Text(
                text = "$132.00",
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    modifier: Modifier = Modifier
) {
    TextField(
        shape = TextFieldDefaults.outlinedShape.apply { RoundedCornerShape(20.dp) },
        value = "",
        onValueChange = {},
        modifier = modifier
            .fillMaxWidth()
            .heightIn(56.dp),
        placeholder = { Text(text = "Search") },
        leadingIcon = {
            Icon(
                imageVector = Icons.Outlined.Search,
                contentDescription = "Search Icon"
            )
        },
    )
}

//}
//    SearchBar()
//fun SearchBarPreview() {
//@Composable
//@Preview(showBackground = true)
//@Composable
//fun ProductCardPreview() {
//    ProductCard(modifier = Modifier)
//}
//
@Preview(showBackground = true, widthDp = 320, heightDp = 720)
@Composable
fun PreviewHomeScreen() {
    HomeScreen(modifier = Modifier)
}
