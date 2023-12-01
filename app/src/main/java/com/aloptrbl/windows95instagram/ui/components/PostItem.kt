package com.aloptrbl.windows95instagram.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.aloptrbl.windows95instagram.model.Post

@Composable
fun PostItem(post: Post, navController: NavHostController, onClick: () -> Unit) {
    var isSelected by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .clickable {
                isSelected = !isSelected
                onClick()
            }
            .padding(1.dp)
            .fillMaxHeight()
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Image(painter = painterResource(id = post.image), "", Modifier.fillMaxSize())
    }

}
