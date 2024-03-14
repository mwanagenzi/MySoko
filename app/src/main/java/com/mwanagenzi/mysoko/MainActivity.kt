package com.mwanagenzi.mysoko

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mwanagenzi.mysoko.ui.screens.CartScreen
import com.mwanagenzi.mysoko.ui.screens.HomeScreen
import com.mwanagenzi.mysoko.ui.screens.SignUpScreen
import com.mwanagenzi.mysoko.ui.theme.MySokoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MySokoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
//                        AppLogo()
//                        AppName("My Soko")
//                    }
                    HomeScreen(modifier = Modifier)
                }
            }
        }
    }
}

@Composable
fun AppName(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "$name!",
        modifier = modifier,
        style = TextStyle(fontWeight = FontWeight.Medium, fontFamily = FontFamily.SansSerif)
    )
}

@Preview(showBackground = true)
@Composable
fun AppNamePreview() {
    MySokoTheme {
        AppName("MySoko")
    }
}

@Composable
fun AppLogo() {
    Image(
        painter = painterResource(id = R.drawable.basket),
        contentDescription = "App Logo",
        modifier = Modifier.size(100.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    MySokoTheme {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        ) {
            AppLogo()
            Spacer(modifier = Modifier.height(18.dp))
            AppName(name = "My Soko")
        }
    }
}
