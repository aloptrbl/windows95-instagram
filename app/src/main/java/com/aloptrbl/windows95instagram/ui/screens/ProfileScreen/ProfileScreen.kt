package com.aloptrbl.windows95instagram.ui.screens.ProfileScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.aloptrbl.windows95instagram.R
import com.aloptrbl.windows95instagram.ui.components.HorizontalLine
import com.aloptrbl.windows95instagram.ui.components.RoundedImage
import com.aloptrbl.windows95instagram.ui.components.WinBox
import com.aloptrbl.windows95instagram.ui.components.WinButton
import com.aloptrbl.windows95instagram.ui.components.WinDialog
import com.aloptrbl.windows95instagram.ui.components.WinDropDownMenu
import com.aloptrbl.windows95instagram.ui.components.WinIconButton
import com.aloptrbl.windows95instagram.ui.theme.HeaderBlue

@Composable
fun ProfileScreen(navController: NavHostController) {

    WinBox(modifier = Modifier) {
        Row(
            Modifier
                .fillMaxWidth()
                .height(60.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
            Text(text ="Aloptrbl", fontSize = 25.sp  ,fontFamily = FontFamily(Font(R.font.gidugu)))
        }
        HorizontalLine()
        Row(Modifier.padding(10.dp)) {
            RoundedImage(image = R.drawable.skull, 80.dp)
            Spacer(modifier = Modifier.width(16.dp))
            Column() {
                Row(
                    Modifier
                        .padding(horizontal = 15.dp)
                        .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("60", fontWeight = FontWeight.Bold)
                        Text("posts")
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("11.1k", fontWeight = FontWeight.Bold)
                        Text("followers")
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("569", fontWeight = FontWeight.Bold)
                        Text("following")
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                Row(Modifier.fillMaxWidth()) {
                    WinButton(onClick = {
                    }, modifier = Modifier
                        .height(30.dp)
                        .fillMaxWidth()
                        .weight(1f), "+ Follow")
                    WinIconButton(onClick = {
                    }, modifier = Modifier
                        .height(30.dp)
                        .width(30.dp), content = {
                        Row(Modifier.fillMaxSize(),horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                            Icon(painter = painterResource(id = R.drawable.arrow_down), contentDescription = "", Modifier.size(10.dp))
                        }
                    })
                }
            }
        }
        Column(Modifier.padding(horizontal = 12.dp, vertical = 12.dp)) {
            Column(horizontalAlignment = Alignment.Start) {
                Text("Mohamad Zulhilmi Azaha", fontWeight = FontWeight.Bold, fontSize = 13.sp)
                Text("Carpe Diem", fontSize = 13.sp)
                Text("www.x.com/xinthepool", fontSize = 13.sp)
            }
        }
        HorizontalLine()
        TabLayoutWithIcons(navController)

    }
}