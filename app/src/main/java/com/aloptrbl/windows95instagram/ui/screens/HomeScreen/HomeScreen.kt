package com.aloptrbl.windows95instagram.ui.screens.HomeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.aloptrbl.windows95instagram.R
import com.aloptrbl.windows95instagram.model.itemsList
import com.aloptrbl.windows95instagram.ui.components.PostGrid
import com.aloptrbl.windows95instagram.ui.components.PostList
import com.aloptrbl.windows95instagram.ui.components.WinBox
import com.aloptrbl.windows95instagram.ui.components.WinIconButton
import com.aloptrbl.windows95instagram.ui.theme.WinPrimary

@Composable
fun HomeScreen(navController: NavHostController) {
    var items = remember { mutableStateOf(itemsList) }
    Column(
        Modifier
            .fillMaxSize()
            .background(WinPrimary), horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.Top) {
        WinBox(
            Modifier
                .height(50.dp)
                .fillMaxWidth()) {
            Row(verticalAlignment = Alignment.CenterVertically,  horizontalArrangement = Arrangement.SpaceBetween,modifier = Modifier.fillMaxSize()) {
                Row() {
                    Text(text ="Instagram", fontSize = 20.sp, fontWeight = FontWeight.Bold ,modifier = Modifier.padding(horizontal = 10.dp))
                }
                Row() {
                    WinIconButton(onClick = { items.value = items.value.shuffled() },
                        Modifier
                            .width(50.dp)
                            .fillMaxHeight()
                            .padding(horizontal = 0.dp)) {
                        Row(
                            Modifier.fillMaxSize(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.reload),
                                contentDescription = "",
                                modifier = Modifier.size(25.dp)
                            )
                        }
                    }
                }
            }
        }
        WinBox(modifier = Modifier
            .padding(3.dp, 5.dp)
            .fillMaxSize()) {
            PostList(posts = items.value, navController = navController)
        }
    }
}