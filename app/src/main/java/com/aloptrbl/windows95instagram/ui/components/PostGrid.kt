package com.aloptrbl.windows95instagram.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.aloptrbl.windows95instagram.model.Post

@Composable
fun PostGrid(posts: List<Post>, navController: NavHostController) {
    var itemsList by remember { mutableStateOf(posts) }
    val scrollState = rememberLazyGridState()
    LaunchedEffect(posts) {
        itemsList = posts
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier.fillMaxWidth(),
        state = scrollState
    ) {
        items(itemsList.size) { item ->
            PostItem(post = itemsList[item], navController = navController, onClick = { handlePostClick(itemsList[item]) })
        }
    }
}

fun handlePostClick(post: Post) {
    // Handle the post click here. This might involve navigating to a new screen
    // with the NavHostController, updating some state, etc.
}
