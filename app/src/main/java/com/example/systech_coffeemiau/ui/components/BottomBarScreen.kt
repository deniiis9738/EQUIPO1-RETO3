package com.example.systech_coffeemiau.ui.components

import com.example.systech_coffeemiau.R

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: Int,
    val icon_focused: Int
) {

    object Home: BottomBarScreen(
        route = "productos",
        title = "Productos",
        icon = R.drawable.ic_bottom_home,
        icon_focused = R.drawable.ic_bottom_home_focused
    )

    object Cat: BottomBarScreen(
        route = "gatos",
        title = "Gatos",
        icon = R.drawable.ic_bottom_cat,
        icon_focused = R.drawable.ic_bottom_cat_focused
    )

    object Profile: BottomBarScreen(
        route = "perfil",
        title = "Perfil",
        icon = R.drawable.ic_bottom_profile,
        icon_focused = R.drawable.ic_bottom_profile_focused
    )

}