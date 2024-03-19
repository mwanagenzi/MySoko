package com.mwanagenzi.mysoko.ui.screens

import android.os.Looper
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.mwanagenzi.mysoko.R

@Composable
fun SplashScreen(modifier: Modifier, onSplashScreenTimeout: () -> Unit) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppLogo(appLogoDrawable = R.drawable.basket)
        Spacer(modifier = Modifier.height(18.dp))
        AppName()
        Spacer(modifier = modifier.height(48.dp))
        ProgressLoader()
    }
    loadLoginScreen { onSplashScreenTimeout() }
}

@Composable
private fun AppName(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(id = R.string.app_name),
        modifier = modifier,
        style = MaterialTheme.typography.titleLarge.copy(
            fontWeight = FontWeight.Medium,
            fontFamily = FontFamily.SansSerif
        )
    )
}

@Composable
private fun AppLogo(
    @DrawableRes appLogoDrawable: Int
) {
    Image(
        painter = painterResource(id = appLogoDrawable),
        contentDescription = "App Logo",
    )
}

@Composable
private fun ProgressLoader() {
    CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
}

fun loadLoginScreen(onTimeout: () -> Unit) {
    android.os.Handler(Looper.getMainLooper()).postDelayed({
        onTimeout()
    }, 3000)
}
