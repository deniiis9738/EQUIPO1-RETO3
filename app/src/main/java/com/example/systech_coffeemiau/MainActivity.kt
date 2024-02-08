package com.example.systech_coffeemiau

import com.example.systech_coffeemiau.ui.screens.LoginView
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.systech_coffeemiau.ui.components.BottomBarScreen
import com.example.systech_coffeemiau.ui.screens.product.ProductListScreen
import com.example.systech_coffeemiau.ui.screens.userDates.UserDatesScreen
import com.example.systech_coffeemiau.ui.theme.Systech_CoffeeMiauTheme
import com.example.systech_coffeemiau.ui.viewsmodels.LoginViewModel
import com.example.systech_coffeemiau.ui.viewsmodels.ProductoViewModel
import compose.material.theme.bottomnav.BottomNav
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Systech_CoffeeMiauTheme {
                val navController = rememberNavController()
                val loginViewModel: LoginViewModel by viewModels()
                val productoViewModel: ProductoViewModel by viewModels()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = { BottomNav(navController) }
                ) {

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = it.calculateTopPadding())
                            .background(Color.Transparent)
                    ) {
                        NavHost(
                            navController = navController,
                            startDestination = /*if(loginViewModel.isAuthenticated()) "ProductosView" else*/ "LoginView"
                        ) {
                            composable("LoginView") {
                                LoginView(loginViewModel, navController)
                            }
                            composable("ProductosView") {
                                ProductListScreen(productoViewModel)
                            }
                            composable(route = BottomBarScreen.Productos.route) {
                                ProductListScreen(productoViewModel)
                            }
                            composable(route = BottomBarScreen.Cat.route) {
                                ProductListScreen(productoViewModel)
                            }
                            composable(route = BottomBarScreen.Profile.route) {
                                UserDatesScreen(loginViewModel)
                            }
                        }
                    }
                }
            }
        }
    }
}