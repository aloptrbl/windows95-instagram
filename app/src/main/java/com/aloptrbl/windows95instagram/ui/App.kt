package com.aloptrbl.windows95instagram.ui

import android.content.Intent
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aloptrbl.windows95instagram.model.Screen
import com.aloptrbl.windows95instagram.ui.activity.CameraActivity
import com.aloptrbl.windows95instagram.ui.components.BottomTabBar
import com.aloptrbl.windows95instagram.ui.components.HeaderTopBar
import com.aloptrbl.windows95instagram.ui.screens.CameraScreen.CameraScreen
import com.aloptrbl.windows95instagram.ui.screens.ExploreScreen.ExploreScreen
import com.aloptrbl.windows95instagram.ui.screens.HomeScreen.HomeScreen
import com.aloptrbl.windows95instagram.ui.screens.NotificationScreen.NotificationScreen
import com.aloptrbl.windows95instagram.ui.screens.ProfileScreen.ProfileScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {
    val navController = rememberNavController()
    val context = LocalContext.current
    val items = listOf(
        Screen.Home,
        Screen.Explore,
        Screen.Camera,
        Screen.Notification,
        Screen.Profile
    )

    Scaffold(
        topBar = { HeaderTopBar() },
        bottomBar = { BottomTabBar(navController, items)}
    )  { innerPadding ->
        NavHost(navController = navController, startDestination = Screen.Home.route, enterTransition = {  -> EnterTransition.None }, exitTransition = {  -> ExitTransition.None },  modifier = Modifier.padding(innerPadding)) {
            composable(Screen.Profile.route) { ProfileScreen(navController) }
            composable(Screen.Home.route) { HomeScreen(navController) }
            composable(Screen.Explore.route) { ExploreScreen(navController) }
            composable(Screen.Notification.route) { NotificationScreen(navController) }
            composable("details") { ExploreScreen(navController) }
        }
    }


}