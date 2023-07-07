package com.aa.personaltask.screens.home_screen


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.aa.personaltask.composable.HomeButton
import com.aa.personaltask.composable.HomeHorizontalPager
import com.aa.personaltask.composable.HomeNavBar
import com.aa.personaltask.composable.OutlinedButton
import com.aa.personaltask.composable.SpacerHorizontal4
import com.aa.personaltask.composable.SpacerVertical16
import com.aa.personaltask.composable.SpacerVertical32
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel(),
){
    val state by viewModel.state.collectAsState()
    val pagerState = rememberPagerState()
    HomeContent(
        movies = state,
        pagerState = pagerState,
        navigateToDetails = { navController.navigate("movie screen") }

    )

}


@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun HomeContent(
    movies: HomeUiState,
    pagerState: PagerState,
    navigateToDetails: () -> Unit
) {
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme()
    systemUiController.setSystemBarsColor(
        color = Color.Transparent,
        darkIcons = useDarkIcons,
        isNavigationBarContrastEnforced = false
    )
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .blur(20.dp),
            contentScale = ContentScale.Crop,
            painter = rememberAsyncImagePainter(model = movies.movies[pagerState.currentPage].imageUrl),
            contentDescription = "",

        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .blur(19.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Transparent,
                            Color.White,
                            Color.White
                        )
                    )
                )
        )
    }
        LazyColumn() {
            item {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    SpacerVertical32()
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        HomeButton(text = "Now Showing")
                        SpacerHorizontal4()
                        OutlinedButton(text = "Coming Soon")
                    }
                    SpacerVertical16()
                    Box(modifier = Modifier.fillMaxWidth()) {
                        HomeHorizontalPager(movies = movies.movies, pagerState = pagerState, onClick = navigateToDetails)
                    }
                    SpacerVertical32()
                    HomeNavBar()

                }
            }
        }
    }





//@OptIn(ExperimentalFoundationApi::class)
//@Preview(showSystemUi = true)
//@Composable
//fun PreviewHomeContent(){
//    HomeContent(
//        pagerState = rememberPagerState() ,
//        movies = HomeUiState(
//            listOf(
//                MovieUiState(
//                    0,
//                    "Fantastic Beast: The \n Secret of Dumbledore ",
//                    "https://m.media-amazon.com/images/M/MV5BNDE3ODcxYzMtY2YzZC00NmNlLWJiNDMtZDViZWM2MzIxZDYwXkEyXkFqcGdeQXVyNjAwNDUxODI@._V1_FMjpg_UX1200_.jpg",
//                    "2h 23m",
//                    listOf(
//                        CategoryUiState("Action"),
//                        CategoryUiState("Drama"),
//                        CategoryUiState("Fantasy"),
//                    )
//                ),
//                MovieUiState(
//                    0,
//                    "Fantastic Beast: The \n Secret of Dumbledore",
//                    "https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_FMjpg_UY1982_.jpg",
//                    "50",
//                    listOf(
//                        CategoryUiState("Action"),
//                        CategoryUiState("Drama"),
//                        CategoryUiState("Fantasy"),
//                    )
//                ),
//                MovieUiState(
//                    0,
//                    "Fantastic Beast: The \n Secret of Dumbledore",
//                    "https://m.media-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_FMjpg_UY2048_.jpg",
//                    "50",
//                    listOf(
//                        CategoryUiState("Action"),
//                        CategoryUiState("Drama"),
//                        CategoryUiState("Fantasy"),
//                    )
//                ),
//                MovieUiState(
//                    0,
//                    "Fantastic Beast: The \n Secret of Dumbledore",
//                    "https://m.media-amazon.com/images/M/MV5BNzA5ZDNlZWMtM2NhNS00NDJjLTk4NDItYTRmY2EwMWZlMTY3XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_FMjpg_UX800_.jpg",
//                    "50",
//                    listOf(
//                        CategoryUiState("Action"),
//                        CategoryUiState("Drama"),
//                        CategoryUiState("Fantasy"),
//                    )
//                ),
//            )
//    )
//    )
//}