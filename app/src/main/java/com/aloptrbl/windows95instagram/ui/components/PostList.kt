package com.aloptrbl.windows95instagram.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.rememberLazyListState
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
fun PostList(posts: List<Post>, navController: NavHostController) {
    var itemsList by remember { mutableStateOf(posts) }
    val scrollState = rememberLazyListState()
    LaunchedEffect(posts) {
        itemsList = posts
    }

    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        state = scrollState
    ) {
        items(itemsList.size) { item ->
            PostListItem(post = itemsList[item], navController = navController, onClick = { handlePostClick(itemsList[item]) })
        }
    }
}
