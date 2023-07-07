package com.aa.personaltask.screens.movie_details


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aa.personaltask.composable.BottomSheetDetailsScreen
import com.aa.personaltask.composable.TopContentDetailsScreen

@Composable
fun MovieDetailsScreen(
    navController: NavController,
    viewModel: MovieDetailsViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()
    DetailsContent(
        state = state,
        navigateToBookingScreen = { navController.navigate("booking screen") }
    )
}


@Composable
private fun DetailsContent(
    state: MovieDetailsUiState,
    navigateToBookingScreen: ()-> Unit
) {
    LazyColumn() {
       item {
           ConstraintLayout(modifier = Modifier.fillMaxSize()) {
               val (topScreen, bottomSheet) = createRefs()

               val guideLine = createGuidelineFromTop(.5f)

               TopContentDetailsScreen(
                   state = state,
                   modifier = Modifier.constrainAs(topScreen) {
                       top.linkTo(parent.top)
                   }
               )

               BottomSheetDetailsScreen(
                   state = state,
                   modifier = Modifier.clip(RoundedCornerShape(16.dp)).constrainAs(bottomSheet) {
                       top.linkTo(guideLine)
                   },
                   navigateToBookingScreen
               )
           }
       }
    }


}


