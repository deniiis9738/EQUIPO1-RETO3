package compose.material.theme.bottomnav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.systech_coffeemiau.ui.components.BottomBarScreen
import com.example.systech_coffeemiau.ui.screens.product.ProductListScreen
import com.example.systech_coffeemiau.ui.viewsmodels.ProductoViewModel

@Composable
fun BottomNavGraph(
    navController: NavHostController,
    productoViewModel: ProductoViewModel
) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            ProductListScreen(productoViewModel)
        }
        composable(route = BottomBarScreen.Cat.route) {
            ProductListScreen(productoViewModel)
        }
        composable(route = BottomBarScreen.Profile.route) {
            ProductListScreen(productoViewModel)
        }
    }
}