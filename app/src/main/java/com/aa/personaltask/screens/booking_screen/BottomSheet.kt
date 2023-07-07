package com.aa.personaltask.screens.booking_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aa.personaltask.R
import com.aa.personaltask.composable.CustomButton
import com.aa.personaltask.ui.theme.Primary

@Composable
fun BottomSheetBooking(
    modifier: Modifier = Modifier,
    state: BookingUiState,

) {
    Column(
        modifier = modifier.fillMaxSize()
        .background(Color.White)
    ) {
        LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(16.dp)){
           items(state.days){
               BookingChips(firstText = it.dayNumber, secondText = it.dayName)
           }
        }
        LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(bottom = 32.dp, start = 16.dp, end = 16.dp)
        ){
            items(state.times){
                BookingChips(firstText = it.time)
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            PriceText(text = "100.00$", title = "4 tickets")
            CustomButton(
                painter = R.drawable.baseline_credit_card_24,
                backgroundColor = Primary,
                text = "Buy Tickets ",
                textColor = Color.White
            ){}

        }

    }

}


@Preview(showSystemUi = true)
@Composable
fun PreviewBottomSheetBooking() {
    BottomSheetBooking(
        state =
        BookingUiState(
            listOf(
                Days("14","Thu"),
                Days("15","Fri"),
                Days("16","Sat"),
                Days("17","Sun"),
                Days("18","Mon"),
                Days("19","Tue"),
                Days("20","Wed"),
            ),
            listOf(
                Times("10:00"),
                Times("11:00"),
                Times("12:00"),
                Times("13:00"),
                Times("14:00"),
            )
        )
    )
}