package com.aa.personaltask.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.OutlinedButton
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun OutlinedButton(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.White,
){
    OutlinedButton(
        onClick = { /*TODO*/ },
        border = BorderStroke(.5.dp, Color.LightGray),
        modifier = modifier
    ) {
        Text(
            text = text,
            color = color,
            maxLines = 1,

        )
    }
}



@Preview
@Composable
fun PreviewOutlinedButton(){
    OutlinedButton("Coming Soon")
}