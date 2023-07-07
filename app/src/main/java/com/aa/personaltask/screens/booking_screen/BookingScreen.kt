package com.aa.personaltask.screens.booking_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aa.personaltask.R
import com.aa.personaltask.composable.CustomButton
import com.aa.personaltask.composable.FilmImage
import com.aa.personaltask.composable.SpacerVertical16
import com.aa.personaltask.ui.theme.Primary

@Composable
fun BookingScreen(
    navController: NavController,
    viewModel: BookingViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()
    BookingContent(
        state = state,
    )
}

@Composable
private fun BookingContent(
    state: BookingUiState,

) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Black)
    ) {
        SpacerVertical16()
        CustomButton(painter = R.drawable.icons8_close_100, modifier = Modifier.padding(start = 16.dp)){}
        FilmImage()
        CinemaChairs()

        Row(
            modifier = Modifier
                .padding(vertical = 16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            TicketsGuide("Available", circleTint = White)
            TicketsGuide("Taken", circleTint = Gray)
            TicketsGuide("Selected", circleTint = Primary)
        }
        Spacer(modifier = Modifier.weight(1f))

        BottomSheetBooking(
            modifier = Modifier.clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)).fillMaxHeight(),
           state = state
        )
    }
}