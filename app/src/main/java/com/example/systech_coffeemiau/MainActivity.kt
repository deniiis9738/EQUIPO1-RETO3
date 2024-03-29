package com.example.systech_coffeemiau

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.systech_coffeemiau.ui.components.BottomBar
import com.example.systech_coffeemiau.ui.components.BottomBarScreen
import com.example.systech_coffeemiau.ui.components.TopBar
import com.example.systech_coffeemiau.ui.screens.LoginView
import com.example.systech_coffeemiau.ui.screens.cat.GatoListScreen
import com.example.systech_coffeemiau.ui.screens.cat.GatoScreen
import com.example.systech_coffeemiau.ui.screens.product.ProductListScreen
import com.example.systech_coffeemiau.ui.screens.userDates.UserDatesScreen
import com.example.systech_coffeemiau.ui.theme.Systech_CoffeeMiauTheme
import com.example.systech_coffeemiau.ui.viewsmodels.GatoViewModel
import com.example.systech_coffeemiau.ui.viewsmodels.LoginViewModel
import com.example.systech_coffeemiau.ui.viewsmodels.ProductoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Systech_CoffeeMiauTheme {
                val navController = rememberNavController()
                val loginViewModel: LoginViewModel by viewModels()
                val productoViewModel: ProductoViewModel by viewModels()
                val gatoViewModel: GatoViewModel by viewModels()

                var isBarVisible by remember { mutableStateOf(true) }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        if (isBarVisible) {
                            BottomBar(navController, loginViewModel)
                        }
                    },
                    topBar = {
                        if (isBarVisible) {
                            TopBar()
                        }
                    },
                ) {

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(
                                top = it.calculateTopPadding(),
                                bottom = it.calculateTopPadding()
                            )
                            .background(Color.Transparent)
                    ) {
                        NavHost(
                            navController = navController,
                            startDestination = if(loginViewModel.isAuthenticated()) "ProductosView" else "LoginView"
                        ) {
                            composable("LoginView") {
                                isBarVisible = false
                                LoginView(loginViewModel, navController)
                            }
                            composable("ProductosView") {
                                isBarVisible = true
                                ProductListScreen(productoViewModel)
                            }
                            composable("GatosList_View") {
                                isBarVisible = true
                                GatoListScreen(navController, gatoViewModel)
                            }
                            composable("GatoDetail_View") {
                                isBarVisible = true
                                GatoScreen(gatoViewModel)
                            }

                            //BOTTOM BAR
                            composable(route = BottomBarScreen.Productos.route) {
                                isBarVisible = true
                                ProductListScreen(productoViewModel)
                            }
                            composable(route = BottomBarScreen.Cat.route) {
                                isBarVisible = true
                                GatoListScreen(navController, gatoViewModel)
                            }
                            composable(route = BottomBarScreen.Profile.route) {
                                isBarVisible = true
                                UserDatesScreen(loginViewModel, navController)
                            }
                        }
                    }
                }
            }
        }
    }
}