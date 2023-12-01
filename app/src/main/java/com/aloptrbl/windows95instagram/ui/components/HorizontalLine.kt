package com.aloptrbl.windows95instagram.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun HorizontalLine() {
    Column(Modifier.padding(horizontal = 5.dp)) {
        Box(
            Modifier
                .height(2.dp)
                .fillMaxWidth()
                .background(Color.Gray.copy(0.5F))) {
        }
        Box(
            Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(Color.White)) {
        }
    }

}