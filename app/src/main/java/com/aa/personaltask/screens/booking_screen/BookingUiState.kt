package com.aa.personaltask.screens.booking_screen

data class BookingUiState(
    val days : List<Days> = emptyList(),
    val times : List<Times> = emptyList()
)

data class Days(
    val dayNumber : String ,
    val dayName: String
)

data class Times(
    val time : String
)