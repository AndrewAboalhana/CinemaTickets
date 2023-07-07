package com.aa.personaltask.screens.movie_details

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class MovieDetailsViewModel: ViewModel() {

    private val _state = MutableStateFlow(MovieDetailsUiState())
    val state = _state.asStateFlow()


    init {
        getMovieDetails()
    }



    private fun getMovieDetails(){
        _state.update {
            it.copy(
                title = "Fantastic Beast: The Secret of Dumbledore",
                imageUrl = "https://m.media-amazon.com/images/M/MV5BZGQ1NjQyNDMtNzFlZS00ZGIzLTliMWUtNGJkMGMzNTBjNDg0XkEyXkFqcGdeQXVyMTE1NDI5MDQx._V1_.jpg",
                description = "Professor Albus Dumbledore must assist Newt Scamander and his partners as Grindelwald begins to lead an army to eliminate all Muggles.",
                time = "2h 23m",
                imdb = "6.8",
                rottenTomatoes = "63%",
                ign = "4",
                category = listOf(
                   CategoryUiState("Fantasy"),
                   CategoryUiState("Adventure"),
                ),
                creators = listOf(
                    CreatorsUiState("https://www.mrdustbin.com/en/wp-content/uploads/2021/05/leonardo-dicaprio-853x1024.jpg"),
                    CreatorsUiState("https://i0.wp.com/flickside.com/wp-content/uploads/2022/11/highest-paid-actors.jpg?fit=1200%2C900&ssl=1"),
                    CreatorsUiState("https://compote.slate.com/images/fd268400-c348-4021-82bb-3d0a1962e257.jpg"),
                    CreatorsUiState("https://www.mrdustbin.com/en/wp-content/uploads/2021/05/matthew-mcconaughey.jpg"),
                    CreatorsUiState("https://source.boomplaymusic.com/buzzgroup2/M00/1E/5E/rBEeJGDZEjCAeV-lAAMf9WslsG074.webp"),
                    CreatorsUiState("https://source.boomplaymusic.com/buzzgroup2/M00/1E/5E/rBEeJGDZEjCAeV-lAAMf9WslsG074.webp"),
                    CreatorsUiState("https://source.boomplaymusic.com/buzzgroup2/M00/1E/5E/rBEeJGDZEjCAeV-lAAMf9WslsG074.webp"),
                    CreatorsUiState("https://source.boomplaymusic.com/buzzgroup2/M00/1E/5E/rBEeJGDZEjCAeV-lAAMf9WslsG074.webp"),
                    CreatorsUiState("https://source.boomplaymusic.com/buzzgroup2/M00/1E/5E/rBEeJGDZEjCAeV-lAAMf9WslsG074.webp"),
                )
            )
        }
    }
}