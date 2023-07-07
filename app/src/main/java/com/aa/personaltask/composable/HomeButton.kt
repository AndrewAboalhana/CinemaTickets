package com.aa.personaltask.composable

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.aa.personaltask.ui.theme.Primary

@Composable
fun HomeButton(text:String){
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(Primary)
    ) {
        Text(text = text)
    }
}


@Preview()
@Composable
fun PreviewHomeButton(){
    HomeButton("Now Showing")
}