package com.aloptrbl.windows95instagram.ui.components

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aloptrbl.windows95instagram.ui.theme.WinPrimary

@Composable
fun WinDropDownMenu(expand: MutableState<Boolean>, openDialog: MutableState<Boolean>) {
    val context = LocalContext.current
    val activity = LocalContext.current as? Activity
    if(expand.value) {
            DropdownMenu(expanded = expand.value, onDismissRequest = { /*TODO*/ },
                Modifier
                    .padding(0.dp)
                    .background(
                        WinPrimary
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
                    }) {
                DropdownMenuItem({
                    Text(text = "About Me", fontSize = 12.sp, modifier = Modifier.padding(0.dp))
                }, onClick = {
                    expand.value = false
                    openDialog.value = true
                },
                    Modifier
                        .padding(0.dp)
                        .height(15.dp))
                HorizontalLine()
                DropdownMenuItem({
                    Text(text = "Exit", fontSize = 12.sp, modifier = Modifier.padding(0.dp))
                }, onClick = {
                    expand.value = false
                    activity?.finish()
                },
                    Modifier
                        .padding(0.dp)
                        .height(15.dp))
            }
    }
}