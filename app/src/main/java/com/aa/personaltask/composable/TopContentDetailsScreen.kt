package com.aa.personaltask.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.aa.personaltask.R
import com.aa.personaltask.screens.movie_details.MovieDetailsUiState
import com.aa.personaltask.ui.theme.Primary

@Composable
 fun TopContentDetailsScreen(
    state: MovieDetailsUiState,
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier.aspectRatio(4f/5f)
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = state.imageUrl),
            contentDescription = "Movie Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp, start = 16.dp, end = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CustomButton(painter = R.drawable.icons8_close_100){}
            CustomButton(painter = R.drawable.baseline_access_time_24, text = state.time){}
        }

        CustomButton(
            painter = R.drawable.outline_play_arrow_24,
            modifier = Modifier.size(64.dp)
                .align(Alignment.Center),
            backgroundColor = Primary,
        ){}
    }
}