package com.aloptrbl.windows95instagram.ui.screens.ProfileScreen.TabView.GridView

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.aloptrbl.windows95instagram.R
import com.aloptrbl.windows95instagram.model.Post
import com.aloptrbl.windows95instagram.model.itemsList
import com.aloptrbl.windows95instagram.ui.components.PostGrid
import com.aloptrbl.windows95instagram.ui.components.PostItem
import com.aloptrbl.windows95instagram.ui.components.WinBox

@Composable
fun GridView(navController: NavHostController) {
    val scrollState = rememberLazyGridState()
    WinBox(modifier = Modifier
        .padding(3.dp, 5.dp)
        .fillMaxSize()) {
      PostGrid(posts = itemsList, navController = navController)
    }
}