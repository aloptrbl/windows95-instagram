package com.aloptrbl.windows95instagram.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.aloptrbl.windows95instagram.R
import com.aloptrbl.windows95instagram.ui.theme.HeaderBlue

@Composable
fun WinDialog(
    openDialog: MutableState<Boolean>,
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    painter: Painter,
    imageDescription: String,
) {
    val haptic = LocalHapticFeedback.current
    if (openDialog.value) {
    Dialog(onDismissRequest = { onDismissRequest() }) {
        WinBox(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
                .padding(16.dp),
        ) {
            Column() {
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
                        WinIconButton(
                            onClick = {
                                haptic.performHapticFeedback(
                                    HapticFeedbackType.LongPress
                                )
                            },
                            Modifier
                                .height(23.dp)
                                .width(23.dp)
                                .padding(horizontal = 0.dp)
                        ) {
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
                        WinIconButton(
                            onClick = {
                                haptic.performHapticFeedback(
                                    HapticFeedbackType.LongPress
                                )
                            },
                            Modifier
                                .height(23.dp)
                                .width(23.dp)
                                .padding(horizontal = 2.dp)
                        ) {
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
                        WinIconButton(
                            onClick = {
                                haptic.performHapticFeedback(
                                    HapticFeedbackType.LongPress
                                )
                            },
                            Modifier
                                .height(23.dp)
                                .width(23.dp)
                                .padding(horizontal = 0.dp)
                        ) {
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
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                ) {
                    Image(painter = painterResource(id = R.drawable.me), "", Modifier.fillMaxWidth().height(100.dp))
                    Text(
                        text = "♥ www.github.com/aloptrbl ♥ codepen.io/aloptrbl",
                        modifier = Modifier.padding(16.dp),
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        WinButton(
                            onClick = { onConfirmation() },
                            modifier = Modifier.padding(8.dp),
                            "Confirm"
                        )

                        WinButton(
                            onClick = { onDismissRequest() },
                            modifier = Modifier.padding(8.dp),
                            "Cancel"
                        )
                    }
                }
            }
        }
        }
    }
}

