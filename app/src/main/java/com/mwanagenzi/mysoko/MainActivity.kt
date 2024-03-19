package com.mwanagenzi.mysoko

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mwanagenzi.mysoko.ui.screens.AuthScreen
import com.mwanagenzi.mysoko.ui.screens.CartScreen
import com.mwanagenzi.mysoko.ui.screens.CheckoutScreen
import com.mwanagenzi.mysoko.ui.screens.EditProfileScreen
import com.mwanagenzi.mysoko.ui.screens.HomeScreen
import com.mwanagenzi.mysoko.ui.screens.LoginScreen
import com.mwanagenzi.mysoko.ui.screens.ProductScreen
import com.mwanagenzi.mysoko.ui.screens.SignUpScreen
import com.mwanagenzi.mysoko.ui.screens.SplashScreen
import com.mwanagenzi.mysoko.ui.screens.UserProfileScreen
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
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = MySokoScreens.SplashScreen.name,
                    ) {
                        composable(MySokoScreens.SplashScreen.name) {
                            SplashScreen(
                                modifier = Modifier,
                                onSplashScreenTimeout = { navController.navigate(MySokoScreens.AuthScreen.name) })
                        }
                        composable(MySokoScreens.AuthScreen.name) {
                            AuthScreen(
                                modifier = Modifier,
                                onLoginButtonClicked = { navController.navigate(MySokoScreens.LoginScreen.name) },
                                onSignUpButtonClicked = { navController.navigate(MySokoScreens.SignUpScreen.name) })
                        }
                        composable(MySokoScreens.CartScreen.name) {
                            CartScreen(
                                modifier = Modifier,
                                onCheckoutBtnPressed = { navController.navigate(MySokoScreens.HomeScreen.name) })
                        }
                        composable(MySokoScreens.CheckoutScreen.name) {
                            CheckoutScreen(modifier = Modifier)
                        }
                        composable(MySokoScreens.EditProfileScreen.name) {
                            EditProfileScreen(
                                modifier = Modifier,
                                onSaveBtnPressed = { navController.navigate(MySokoScreens.UserProfileScreen.name) })
                        }
                        composable(MySokoScreens.HomeScreen.name) {
                            HomeScreen(
                                modifier = Modifier,
                                onProductCardClicked = { navController.navigate(MySokoScreens.ProductScreen.name) },
                                onProfileButtonClicked = { navController.navigate(MySokoScreens.UserProfileScreen.name) })
                        }
                        composable(MySokoScreens.LoginScreen.name) {
                            LoginScreen(
                                modifier = Modifier,
                                onLoginButtonClicked = { navController.navigate(MySokoScreens.HomeScreen.name) })
                        }
                        composable(MySokoScreens.ProductScreen.name) {
                            ProductScreen(
                                modifier = Modifier,
                                onAddToCartButtonClicked = { navController.navigate(MySokoScreens.CartScreen.name) })
                        }
                        composable(MySokoScreens.SignUpScreen.name) {
                            SignUpScreen(
                                modifier = Modifier,
                                onAgreeButtonClicked = { navController.navigate(MySokoScreens.LoginScreen.name) })
                        }
                        composable(MySokoScreens.UserProfileScreen.name) {
                            UserProfileScreen(
                                modifier = Modifier,
                                onLogoutBtnPressed = {
                                    navController.popBackStack(
                                        MySokoScreens.LoginScreen.name,
                                        false
                                    )
                                },
                                onEditProfileBtnPressed = { navController.navigate(MySokoScreens.EditProfileScreen.name) })
                        }
                    }
                }
            }
        }
    }
}

enum class MySokoScreens {
    SplashScreen,
    AuthScreen,
    CartScreen,
    CheckoutScreen,
    EditProfileScreen,
    HomeScreen,
    LoginScreen,
    ProductScreen,
    SignUpScreen,
    UserProfileScreen,
}
