package com.aa.personaltask.screens.booking_screen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class BookingViewModel: ViewModel() {


    private val _state = MutableStateFlow(BookingUiState())
    val state = _state.asStateFlow()


    init {
        getData()
    }


    private fun getData(){
        _state.update { it.copy(
            days = listOf(
                Days("14","Thu"),
                Days("15","Fri"),
                Days("16","Sat"),
                Days("17","Sun"),
                Days("18","Mon"),
                Days("19","Tue"),
                Days("20","Wed"),
            ),
            times = listOf(
                Times("10:00"),
                Times("11:00"),
                Times("12:00"),
                Times("13:00"),
                Times("14:00"),
            )
        ) }
    }
}