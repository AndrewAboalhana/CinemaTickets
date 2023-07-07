package com.aa.personaltask.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.aa.personaltask.screens.movie_details.CreatorsUiState

@Composable
fun CreatorItem(
    state: CreatorsUiState
){
    Image(
        painter = rememberAsyncImagePainter(model = state.imageUrl),
        contentDescription = "Creator Image",
        modifier = Modifier
            .clip(CircleShape)
            .size(64.dp),
        contentScale = ContentScale.Crop
    )
}






