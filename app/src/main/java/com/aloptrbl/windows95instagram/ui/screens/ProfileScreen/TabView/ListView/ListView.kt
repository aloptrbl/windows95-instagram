package com.aloptrbl.windows95instagram.ui.screens.ProfileScreen.TabView.ListView

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.aloptrbl.windows95instagram.model.itemsList
import com.aloptrbl.windows95instagram.ui.components.PostList
import com.aloptrbl.windows95instagram.ui.components.WinBox

@Composable
fun ListView(navController: NavHostController) {
    WinBox(modifier = Modifier
        .padding(3.dp, 5.dp)
        .fillMaxSize()) {
        PostList(posts = itemsList, navController = navController)
    }
}