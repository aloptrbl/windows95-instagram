package com.aloptrbl.windows95instagram.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.aloptrbl.windows95instagram.R
import com.aloptrbl.windows95instagram.model.Post

@Composable
fun PostListItem(post: Post, navController: NavHostController, onClick: () -> Unit) {
    var isSelected by remember { mutableStateOf(false) }
    Column(Modifier.padding(horizontal = 5.dp, vertical = 15.dp)) {
        Row(Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                RoundedImage(image = post.userImage, size = 30.dp)
                Spacer(Modifier.width(5.dp))
                Text(post.name, fontWeight = FontWeight.Bold, fontSize = 18.sp)
            }
            Column() {
                WinButton(
                    onClick = {  },
                    modifier = Modifier.padding(horizontal = 1.dp),
                    "..."
                )
            }
        }
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
        Spacer(Modifier.height(3.dp))
        Row(Modifier.padding(5.dp,10.dp)) {
            WinButton(
                onClick = {  },
                modifier = Modifier.height(IntrinsicSize.Min).padding(horizontal = 1.dp),
                "Like"
            )
            WinButton(
                onClick = {  },
                modifier = Modifier.height(IntrinsicSize.Min).padding(horizontal = 1.dp),
                "Comment"
            )
            WinButton(
                onClick = {  },
                modifier = Modifier.height(IntrinsicSize.Min).padding(horizontal = 1.dp),
                "Share"
            )
        }
        Spacer(Modifier.height(3.dp))
        Row(Modifier.padding(5.dp,0.dp)) {
            Icon(
                painter = painterResource(R.drawable.like),
                contentDescription = "",
                modifier = Modifier.size(20.dp)
            )
            Spacer(Modifier.width(3.dp))
            Text(post.totalLikes.toString(), fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text("likes", fontWeight = FontWeight.Bold, fontSize = 16.sp)
        }
        Column(Modifier.padding(5.dp,0.dp)) {
            Row() {
                Text(post.name, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Spacer(Modifier.width(5.dp))
                Text(post.caption)
            }
            Text(post.timePosted, fontSize = 13.sp)
        }
    }
}