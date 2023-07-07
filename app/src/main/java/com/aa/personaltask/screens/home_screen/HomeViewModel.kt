package com.aa.personaltask.screens.home_screen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HomeViewModel : ViewModel() {

   private val _state = MutableStateFlow(HomeUiState())
    val state = _state.asStateFlow()

    init {
        getAllMovies()
    }

    private fun getAllMovies(){
        _state.update { it.copy(
            movies = listOf(
                MovieUiState(
                    0,
                    "Fantastic Beast: The Secret of Dumbledore ",
                    "https://m.media-amazon.com/images/M/MV5BNDE3ODcxYzMtY2YzZC00NmNlLWJiNDMtZDViZWM2MzIxZDYwXkEyXkFqcGdeQXVyNjAwNDUxODI@._V1_FMjpg_UX1200_.jpg",
                    "2h 23m",
                    listOf(
                        CategoryUiState("Action"),
                        CategoryUiState("Drama"),
                        CategoryUiState("Fantasy"),
                    )
                ),
                MovieUiState(
                    0,
                    "Fantastic Beast: The Secret of Dumbledore",
                    "https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_FMjpg_UY1982_.jpg",
                    "2h 23m",
                    listOf(
                        CategoryUiState("Action"),
                        CategoryUiState("Drama"),

                        )
                ),
                MovieUiState(
                    0,
                    "Fantastic Beast: The Secret of Dumbledore",
                    "https://m.media-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_FMjpg_UY2048_.jpg",
                    "2h 23m",
                    listOf(
                        CategoryUiState("Action"),
                        CategoryUiState("Drama"),
                        CategoryUiState("Fantasy"),
                    )
                ),
                MovieUiState(
                    0,
                    "Fantastic Beast: The Secret of Dumbledore",
                    "https://m.media-amazon.com/images/M/MV5BNzA5ZDNlZWMtM2NhNS00NDJjLTk4NDItYTRmY2EwMWZlMTY3XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_FMjpg_UX800_.jpg",
                    "2h 23m",
                    listOf(
                        CategoryUiState("Action"),
                        CategoryUiState("Drama"),
                        CategoryUiState("Fantasy"),
                    )
                ),
            )
        ) }
    }
}