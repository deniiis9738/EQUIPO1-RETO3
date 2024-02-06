package compose.material.theme.bottomnav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.systech_coffeemiau.ui.components.BottomBarScreen
import com.example.systech_coffeemiau.ui.screens.ProductosView
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
            ProductosView(productoViewModel)
        }
        composable(route = BottomBarScreen.Cat.route) {
            ProductosView(productoViewModel)
        }
        composable(route = BottomBarScreen.Profile.route) {
            ProductosView(productoViewModel)
        }
    }
}