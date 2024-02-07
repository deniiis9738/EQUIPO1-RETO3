package com.example.systech_coffeemiau

import LoginView
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.systech_coffeemiau.ui.screens.product.ProductListScreen
import com.example.systech_coffeemiau.ui.theme.Systech_CoffeeMiauTheme
import com.example.systech_coffeemiau.ui.viewsmodels.LoginViewModel
import com.example.systech_coffeemiau.ui.viewsmodels.ProductoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Systech_CoffeeMiauTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) {
                    val navController = rememberNavController()
                    val loginViewModel: LoginViewModel by viewModels()
                    val productoViewModel: ProductoViewModel by viewModels()

                    NavHost(
                        navController = navController,
                        startDestination = "LoginView"
                    ) {
                        composable("LoginView") {
                            LoginView(loginViewModel, navController)
                        }
                        composable("ProductosView") {
                            ProductListScreen(productoViewModel)
                        }
                    }
                }
            }
        }
    }
}