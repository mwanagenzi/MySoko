package com.mwanagenzi.mysoko.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.mwanagenzi.mysoko.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(modifier: Modifier, onCheckoutBtnPressed: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(
                    text = "My Cart",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }, actions = {
                IconButton(onClick = {
                    // todo: Navigate to cart
                }, enabled = true) {
                    Icon(
                        imageVector = Icons.Filled.MoreHoriz,
                        contentDescription = "Shopping Cart Icon"
                    )
                }
            })
        },
        bottomBar = {
            Column {
                Divider(
                    thickness = .5.dp,
                )
                CheckoutButton(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(), onButtonClick = onCheckoutBtnPressed
                )
            }
        }
    ) { innerPadding ->
        Column(modifier.padding(innerPadding)) {
            LazyColumn(
                modifier.weight(2f),
                contentPadding = PaddingValues(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                items(10) {
                    ProductCard(modifier)
                    Divider(thickness = 1.dp, modifier = modifier.padding(vertical = 8.dp))
                }
            }
            PromotionCard(modifier = modifier)
            OrderSummary(modifier = modifier)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ProductCard(modifier: Modifier) {
    Card(colors = CardDefaults.cardColors(containerColor = Color.Transparent)) {
        Row(
            modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = R.drawable.basket),
                contentDescription = "Cart product image",
                modifier
                    .weight(2f)
                    .background(Color.LightGray, shape = RoundedCornerShape(20.dp))
                    .padding(12.dp),
            )
            Column(
                modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp)
                    .weight(4f),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.Start
            ) {
                Row(
                    modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Xbox Series X")
                    IconButton(onClick = {
                        //todo: delete product from cart
                    }) {
                        Icon(
                            imageVector = Icons.Outlined.Delete,
                            contentDescription = "Remove product from cart"
                        )
                    }
                }
                Text(
                    text = "1 TB",
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Light)
                )
                Row(
                    modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "$570.00",
                        style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.ExtraBold),

                        )
                    Row(
                        modifier.padding(end = 8.dp, bottom = 8.dp),
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(
                            onClick = {
                                //todo: reduce qunatity from cart
                            },
                            modifier
                                .border(
                                    1.dp,
                                    color = MaterialTheme.colorScheme.primary,
                                    shape = RoundedCornerShape(size = 5.dp)
                                )
                                .size(30.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Remove,
                                contentDescription = "Reduce quantity"
                            )
                        }
                        Text(
                            text = "1",
                            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium)
                        )
                        IconButton(
                            onClick = {
                                //todo: add quantity product from cart
                            },
                            modifier
                                .border(
                                    1.dp,
                                    color = MaterialTheme.colorScheme.primary,
                                    shape = RoundedCornerShape(size = 5.dp)
                                )
                                .size(30.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Add,
                                contentDescription = "Reduce quantity"
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun PromotionCard(modifier: Modifier) {
    Box(
        modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(MaterialTheme.shapes.small)
            .border(
                1.dp,
                MaterialTheme.colorScheme.onBackground.copy(.3f),
                MaterialTheme.shapes.small
            ),
        contentAlignment = Alignment.Center,
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "ADJ3AK",
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold)
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(text = "Promocode applied", color = MaterialTheme.colorScheme.primary)
                Icon(
                    imageVector = Icons.Filled.CheckCircle,
                    tint = MaterialTheme.colorScheme.primary,
                    contentDescription = "Promoode applied icon"
                )
            }
        }
    }
}

@Composable
fun OrderSummary(modifier: Modifier) {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(horizontal = 16.dp)
    ) {
        OrderSummaryLabel(modifier, summaryLabel = "Subtotal: ", summaryValue = "$800.00")
        OrderSummaryLabel(modifier, summaryLabel = "Delivery Fee: ", summaryValue = "$5.00")
        OrderSummaryLabel(modifier, summaryLabel = "Discount: ", summaryValue = "40%")
    }
}

@Composable
private fun OrderSummaryLabel(modifier: Modifier, summaryLabel: String, summaryValue: String) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Text(text = summaryLabel, style = MaterialTheme.typography.bodyMedium)
        Text(
            text = summaryValue,
            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold)
        )
    }


}

@Composable
private fun CheckoutButton(modifier: Modifier, onButtonClick: () -> Unit) {
    TextButton(
        onClick = onButtonClick,
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.textButtonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = Color.White
        ), modifier = modifier
    ) {
        Text(text = "Checkout for ", style = MaterialTheme.typography.bodyMedium)
        Text(
            text = "$480.00",
            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
        )
    }
}

//@Preview(showBackground = true, heightDp = 720, widthDp = 320)
//@Composable
//fun CartScreenPreview() {
//    CartScreen(modifier = Modifier)
//}