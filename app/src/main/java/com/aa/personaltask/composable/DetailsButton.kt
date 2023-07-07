package com.aa.personaltask.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aa.personaltask.ui.theme.GlassColor

@Composable
fun CustomButton(
    painter: Int,
    modifier: Modifier = Modifier,
    backgroundColor: Color = GlassColor,
    text: String = "",
    textSize : Int = 16,
    textColor : Color = Color.LightGray,
    iconTint : Color = Color.White,
    onClick : () -> Unit
) {
    Row(
        modifier = modifier
            .clickable ( onClick = onClick )
            .clip(CircleShape)
            .background(color = backgroundColor)
            .padding(8.dp)
           ,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(painter),
            contentDescription = "button",
            tint = iconTint

        )
        if (text.isNotEmpty()) {
            SpacerHorizontal4()
            Text(
                text = text,
                fontSize = textSize.sp,
                color = textColor
            )
        }
    }
}