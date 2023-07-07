package com.aa.personaltask.composable

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.aa.personaltask.R
import com.aa.personaltask.ui.theme.Primary

@Composable
fun PlayButton(){
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(Primary),
        shape = CircleShape
    ) {
        Icon(painter = painterResource(
            id = R.drawable.outline_play_arrow_24) ,
            contentDescription = "play button" )
    }
}



@Preview
@Composable
fun PreviewPlayButton(){
    PlayButton()
}