package com.aloptrbl.windows95instagram.ui.components

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aloptrbl.windows95instagram.R
import com.aloptrbl.windows95instagram.ui.theme.HeaderBlue
import com.aloptrbl.windows95instagram.ui.theme.WinPrimary

@Composable
fun HeaderTopBar() {
    val activity = LocalContext.current as? Activity
    val menuOptions = listOf("File", "Edit", "View", "Options", "Help")
    val haptic = LocalHapticFeedback.current
    val openDialog = remember { mutableStateOf(false) }
    Column(Modifier.fillMaxWidth().background(WinPrimary)) {
        Row(
            Modifier
                .fillMaxWidth()
                .height(30.dp)
                .background(HeaderBlue)
                .padding(5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row() {
                Image(
                    painter = painterResource(id = R.drawable.instagram),
                    contentDescription = "",
                    modifier = Modifier.size(25.dp)
                )
                Text(text = "Instagram.exe", color = Color.White)
            }
            Row() {
                WinIconButton(onClick = {
                    haptic.performHapticFeedback(
                        HapticFeedbackType.LongPress
                    )
                    activity?.moveTaskToBack(true)
                },
                    Modifier
                        .height(23.dp)
                        .width(23.dp)
                        .padding(horizontal = 0.dp)) {
                    Row(
                        Modifier.fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.minimize),
                            contentDescription = "",
                            modifier = Modifier.size(12.dp)
                        )
                    }
                }
                WinIconButton(onClick = {
                    haptic.performHapticFeedback(
                        HapticFeedbackType.LongPress
                    )
                },
                    Modifier
                        .height(23.dp)
                        .width(23.dp)
                        .padding(horizontal = 2.dp)) {
                    Row(
                        Modifier.fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.maximize),
                            contentDescription = "",
                            modifier = Modifier.size(15.dp)
                        )
                    }
                }
                WinIconButton(onClick = {
                    haptic.performHapticFeedback(
                        HapticFeedbackType.LongPress
                    )
                    activity?.finish()
                },
                    Modifier
                        .height(23.dp)
                        .width(23.dp)
                        .padding(horizontal = 0.dp)) {
                    Row(
                        Modifier.fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.close),
                            contentDescription = "",
                            modifier = Modifier.size(12.dp)
                        )
                    }
                }
            }
        }
        WinDialog(
            openDialog,
            onDismissRequest = { openDialog.value = false },
            onConfirmation = { openDialog.value = false },
            painter = painterResource(id = R.drawable.mancity),
            imageDescription = ""
        )
        Row() {
            menuOptions.withIndex().forEach {
                    (index, it) ->
                var openDropDownMenu = remember { mutableStateOf<Boolean>(false) }
                var position = remember { mutableIntStateOf(0) }
                Box(Modifier.background(WinPrimary)) {
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                                append(it[0].toString())
                            }
                            append(it.substring(1))
                        }  ,
                        fontFamily = FontFamily(Font(R.font.windows)),
                        fontSize = 16.sp,
                        modifier = Modifier
                            .padding(horizontal = 5.dp)
                            .background(WinPrimary)
                            .clickable {
                                haptic.performHapticFeedback(
                                    HapticFeedbackType.LongPress
                                )
                                openDropDownMenu.value = true
                            },
                    )
                    WinDropDownMenu(openDropDownMenu, openDialog)
                    Modifier.align(Alignment.CenterEnd)
                }
            }
        }
    }
}