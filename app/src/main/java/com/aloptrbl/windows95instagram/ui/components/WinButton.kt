package com.aloptrbl.windows95instagram.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aloptrbl.windows95instagram.ui.theme.WinPrimary

@Composable
fun WinButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    text: String
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val scale = if (isPressed) 0.95f else 1f

    Box(
        modifier = modifier
            .scale(scale)
            .background(WinPrimary)
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
            }
            .padding(horizontal = 10.dp, vertical = 2.dp)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            )
    ) {
        Text(
            text = text,
            color = Color.Black,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}