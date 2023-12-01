package com.aloptrbl.windows95instagram.ui.screens.NotificationScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.aloptrbl.windows95instagram.R
import com.aloptrbl.windows95instagram.model.TabItem
import com.aloptrbl.windows95instagram.model.itemsList
import com.aloptrbl.windows95instagram.ui.components.PostGrid
import com.aloptrbl.windows95instagram.ui.components.WinBox
import com.aloptrbl.windows95instagram.ui.components.WinButton
import com.aloptrbl.windows95instagram.ui.components.WinIconButton
import com.aloptrbl.windows95instagram.ui.components.WinTabItem
import com.aloptrbl.windows95instagram.ui.screens.ProfileScreen.TabView.GridView.GridView
import com.aloptrbl.windows95instagram.ui.screens.ProfileScreen.TabView.ListView.ListView
import com.aloptrbl.windows95instagram.ui.screens.ProfileScreen.TabView.MapView.MapView
import com.aloptrbl.windows95instagram.ui.screens.ProfileScreen.TabView.PhotoOfYouView.PhotoOfYouView
import com.aloptrbl.windows95instagram.ui.theme.WinPrimary

@Composable
fun NotificationScreen(navController: NavHostController) {
    var selectedTabIndex by remember { mutableStateOf(0) }
    val tabItems = listOf(
        TabItem("Following", R.drawable.grid),
        TabItem("News", R.drawable.list),
    )
    Column(
        Modifier
            .fillMaxSize()
            .background(WinPrimary), horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.Top) {
        WinBox(
            Modifier
                .height(50.dp)
                .fillMaxWidth()) {
            Row(verticalAlignment = Alignment.CenterVertically,  horizontalArrangement = Arrangement.SpaceBetween,modifier = Modifier.fillMaxSize()) {
                WinIconButton(onClick = {  },
                    Modifier
                        .alpha(0F)
                        .width(50.dp)
                        .fillMaxHeight()
                        .padding(horizontal = 0.dp)) {
                    Row(
                        Modifier.fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.search),
                            contentDescription = "",
                            modifier = Modifier.size(25.dp)
                        )
                    }
                }
                Row() {
                        tabItems.forEachIndexed { index, item ->
                            var selected = selectedTabIndex == index
                            val haptic = LocalHapticFeedback.current

                            WinTabItem(onClick = { selectedTabIndex = index
                                haptic.performHapticFeedback(
                                    HapticFeedbackType.LongPress
                                ) }, text = item.name, modifier = Modifier.background(if(selected) Color.Gray.copy(0.5F) else WinPrimary), selected = selected)
                        }
                }
                Row() {
                    WinIconButton(onClick = {  },
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
            when (selectedTabIndex) {
                0 -> GridView(navController)
                1 -> ListView(navController)
            }
        }
    }
}