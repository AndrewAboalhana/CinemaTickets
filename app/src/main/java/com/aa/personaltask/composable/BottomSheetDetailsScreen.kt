package com.aa.personaltask.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aa.personaltask.R
import com.aa.personaltask.screens.movie_details.MovieDetailsUiState
import com.aa.personaltask.ui.theme.Primary

@Composable
fun BottomSheetDetailsScreen(
    state: MovieDetailsUiState,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Box(modifier = modifier
            .padding(top = 32.dp, bottom = 16.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Row(
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    ) {
                    StatisticsText(text = state.imdb, title = "IMDb")
                    StatisticsText(text = state.rottenTomatoes, title = "Rotten Tomatoes")
                    StatisticsText(text = state.ign, title = "IGN")
                }
                SpacerVertical16()
                Text(
                    text = state.title,
                    fontSize = 22.sp,
                    textAlign = TextAlign.Center
                )
                SpacerVertical16()
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val categories = state.category
                    categories.forEach {
                        DefaultChips(text = it.categoryName)
                    }
                }

                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    contentPadding = PaddingValues(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ){
                    items(state.creators){
                        CreatorItem(state = it)
                    }
                }

                Text(
                    text = state.description,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                )
                SpacerVertical16()
                CustomButton(
                    painter = R.drawable.baseline_credit_card_24,
                    backgroundColor = Primary,
                    text = "Booking",
                    textColor = Color.White,
                    onClick = onClick
                )
            }
        }
    }
}


