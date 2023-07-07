package com.aa.personaltask.screens.movie_details

data class MovieDetailsUiState(
    val title: String = "",
    val description: String = "",
    val imageUrl: String = "",
    val time: String = "",
    val imdb: String = "",
    val rottenTomatoes : String = "",
    val ign : String = "",
    val category: List<CategoryUiState> = emptyList(),
    val creators: List<CreatorsUiState> = emptyList(),
)

data class CategoryUiState(
    val categoryName: String,
)

data class CreatorsUiState(
    val imageUrl: String
)