package com.aa.personaltask.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aa.personaltask.R

@Composable
 fun FilmImage() {
    Image(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, bottom = 16.dp)
            .fillMaxHeight(.20f),
        painter = painterResource(id = R.drawable.background),
        contentScale = ContentScale.FillBounds,
        contentDescription = "Header Image",
    )
}

@Preview()
@Composable
fun PreviewHeader() {
    FilmImage()
}