package com.aloptrbl.windows95instagram.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import com.aloptrbl.windows95instagram.ui.theme.WinPrimary

@Composable
fun WinBox(modifier: Modifier, content: @Composable ColumnScope.() -> Unit) {
    Column(
        modifier = modifier
            .background(WinPrimary)
            .fillMaxSize()
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
        content = content
    )
}