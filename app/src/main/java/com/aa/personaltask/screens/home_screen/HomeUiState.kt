package com.aa.personaltask.screens.home_screen

data class HomeUiState(
    val movies: List<MovieUiState> = emptyList(),
)


data class MovieUiState(
    val id: Int,
    val movieName: String,
    val imageUrl: String,
    val time: String,
    val category: List<CategoryUiState>,
)

data class CategoryUiState(
    val categoryName: String,
)