package com.example.systech_coffeemiau.ui.components

import com.example.systech_coffeemiau.R

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: Int,
    val iconFocused: Int
) {

    data object Productos: BottomBarScreen(
        route = "productos",
        title = "Productos",
        icon = R.drawable.ic_bottom_home,
        iconFocused = R.drawable.ic_bottom_home_focused
    )

    data object Cat: BottomBarScreen(
        route = "gatos",
        title = "Gatos",
        icon = R.drawable.ic_bottom_cat,
        iconFocused = R.drawable.ic_bottom_cat_focused
    )

    data object Profile: BottomBarScreen(
        route = "perfil",
        title = "Perfil",
        icon = R.drawable.ic_bottom_profile,
        iconFocused = R.drawable.ic_bottom_profile_focused
    )

}