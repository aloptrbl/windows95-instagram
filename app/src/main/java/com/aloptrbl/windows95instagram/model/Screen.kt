package com.aloptrbl.windows95instagram.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import com.aloptrbl.windows95instagram.R

sealed class Screen(val route: String, val icon: Int, val label: String) {
    object Home : Screen("home", R.drawable.home, "Home")
    object Explore : Screen("explore", R.drawable.explore, "Explore")
    object Camera : Screen("camera", R.drawable.camera, "Camera")
    object Notification : Screen("notification", R.drawable.notification, "Notification")
    object Profile : Screen("profile", R.drawable.profile, "Profile")
}