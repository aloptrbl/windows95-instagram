package com.aloptrbl.windows95instagram.ui.components

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.aloptrbl.windows95instagram.R
import com.aloptrbl.windows95instagram.model.Screen
import com.aloptrbl.windows95instagram.ui.activity.CameraActivity
import com.aloptrbl.windows95instagram.ui.theme.WinPrimary

@Composable
fun BottomTabBar(
    navController: NavHostController,
    items: List<Screen>,
    modifier: Modifier = Modifier
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val haptic = LocalHapticFeedback.current
    val context = LocalContext.current
    var selectedScreen by remember { mutableStateOf(0) }
    Row(
        modifier = Modifier
            .background(WinPrimary)
            .fillMaxWidth()
            .height(IntrinsicSize.Min),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (item in items) {
            val isSelected = item == items[selectedScreen]
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(1.dp)
                    .height(50.dp)
                    .drawWithContent {
                        drawContent()
                        if (!isSelected) {
                            // Draw lines for selected state
                            // top-left corner (0, 0) to the top-right corner (width, 0)
                            drawLine(
                                color = Color.White,
                                start = Offset.Zero,
                                end = Offset(size.width, 0f),
                                strokeWidth = 4f
                            )
                            // top-left corner (0, 0) to the bottom-left corner (0, height)
                            drawLine(
                                color = Color.White,
                                start = Offset.Zero,
                                end = Offset(0f, size.height),
                                strokeWidth = 4f
                            )
                            // top-right corner (width, 0) to the bottom-right corner (width, height)
                            drawLine(
                                color = Color.Black,
                                start = Offset(size.width, 0f),
                                end = Offset(size.width, size.height),
                                strokeWidth = 4f
                            )
                            // bottom-left corner (0, height) to the bottom-right corner (width, height)
                            drawLine(
                                color = Color.Black,
                                start = Offset(0f, size.height),
                                end = Offset(size.width, size.height),
                                strokeWidth = 4f
                            )
                        } else {
                            // Draw lines for selected state or do nothing
                            drawLine(
                                color = Color.Black,
                                start = Offset.Zero,
                                end = Offset(size.width, 0f),
                                strokeWidth = 4f
                            )
                            drawLine(
                                color = Color.Black,
                                start = Offset.Zero,
                                end = Offset(0f, size.height),
                                strokeWidth = 4f
                            )
                            drawLine(
                                color = Color.White,
                                start = Offset(size.width, 0f),
                                end = Offset(size.width, size.height),
                                strokeWidth = 4f
                            )
                            drawLine(
                                color = Color.White,
                                start = Offset(0f, size.height),
                                end = Offset(size.width, size.height),
                                strokeWidth = 4f
                            )
                        }
                    }
                    .fillMaxWidth()
                    .weight(1F)
                    .align(Alignment.CenterVertically)
                    .background(if (isSelected) Color.White else WinPrimary)
                    .clickable(onClick = {
                        haptic.performHapticFeedback(
                            HapticFeedbackType.LongPress
                        )
                        if(items[items.indexOf(item)].route == Screen.Camera.route) {
                            context.startActivity(Intent(context, CameraActivity::class.java))
                        } else {
                            selectedScreen = items.indexOf(item)
                            navController.navigate(item.route)
                        }
                    }
                    ),
            ) {
                Image(
                    painterResource(id = R.drawable.checker),
                    contentDescription = "",
                    contentScale = ContentScale.FillWidth, // or some other scale
                    modifier = Modifier
                        .matchParentSize()
                        .alpha(if (isSelected) 0.4f else 0f)
                )
                Column(
                    modifier = Modifier
                        .width(IntrinsicSize.Max)
                        .height(IntrinsicSize.Max),
                ) {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = "icon",
                        modifier = Modifier.size(35.dp).alpha(if (isSelected) 1f else 0.7f)
                    )
                }
            }
        }
    }
}