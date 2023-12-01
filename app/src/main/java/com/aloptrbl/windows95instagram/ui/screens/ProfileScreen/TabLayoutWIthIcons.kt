package com.aloptrbl.windows95instagram.ui.screens.ProfileScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.aloptrbl.windows95instagram.R
import com.aloptrbl.windows95instagram.model.TabItem
import com.aloptrbl.windows95instagram.ui.screens.ProfileScreen.TabView.GridView.GridView
import com.aloptrbl.windows95instagram.ui.screens.ProfileScreen.TabView.ListView.ListView
import com.aloptrbl.windows95instagram.ui.screens.ProfileScreen.TabView.MapView.MapView
import com.aloptrbl.windows95instagram.ui.screens.ProfileScreen.TabView.PhotoOfYouView.PhotoOfYouView
import com.aloptrbl.windows95instagram.ui.theme.WinPrimary


@Composable
fun TabLayoutWithIcons(navController: NavHostController) {
    val tabItems = listOf(
        TabItem("Grid", R.drawable.grid),
        TabItem("List", R.drawable.list),
        TabItem("Map", R.drawable.pin_location),
        TabItem("For You", R.drawable.tag)
    )
    var selectedTabIndex by remember { mutableStateOf(0) }
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.fillMaxWidth()) {
            tabItems.forEachIndexed { index, item ->
                var selected = selectedTabIndex == index
                val interactionSource = remember { MutableInteractionSource() }
                val isPressed by interactionSource.collectIsPressedAsState()
                val haptic = LocalHapticFeedback.current
                val scale = if (isPressed) 0.95f else 1f

                var background = if (selected) Color.White.copy(0.5f) else WinPrimary
                Row(
                    modifier = Modifier
                        .scale(scale)
                        .padding(horizontal = 1.dp)
                        .weight(1f)
                        .background(background)
                        .clickable(
                            interactionSource = interactionSource,
                            indication = null,
                            onClick = {
                                selectedTabIndex = index
                                haptic.performHapticFeedback(
                                    HapticFeedbackType.LongPress
                                )
                            }
                        )
                        .drawWithContent {
                            drawContent()
                            drawLine(
                                color = Color.White,
                                start = Offset.Zero,
                                end = Offset(size.width, 0f),
                                strokeWidth = 4f
                            )
                            drawLine(
                                color = Color.White,
                                start = Offset.Zero,
                                end = Offset(0f, size.height),
                                strokeWidth = 4f
                            )
                            drawLine(
                                color = Color.Black,
                                start = Offset(size.width, 0f),
                                end = Offset(size.width, size.height),
                                strokeWidth = 4f
                            )
                            drawLine(
                                color = Color.Black,
                                start = Offset(0f, size.height),
                                end = Offset(size.width, size.height),
                                strokeWidth = 4f
                            )
                        },
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(vertical = 5.dp)
                    ) {
                        Icon(painter = painterResource(id = item.image), contentDescription = "", Modifier.size(20.dp))
                    }

                }
            }
        }
        Row {
            when (selectedTabIndex) {
                0 -> GridView(navController)
                1 -> ListView(navController)
                2 -> MapView()
                3 -> PhotoOfYouView()
            }
        }

    }
}