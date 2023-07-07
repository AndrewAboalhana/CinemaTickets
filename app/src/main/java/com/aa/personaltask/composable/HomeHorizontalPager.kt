package com.aa.personaltask.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import coil.compose.rememberAsyncImagePainter
import com.aa.personaltask.R
import com.aa.personaltask.screens.home_screen.CategoryUiState
import com.aa.personaltask.screens.home_screen.MovieUiState
import com.aa.personaltask.ui.theme.Sans
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun HomeHorizontalPager(
    modifier: Modifier = Modifier,
    movies: List<MovieUiState>,
    pagerState: PagerState,
    onClick: () -> Unit
) {

    HorizontalPager(
        modifier = modifier,
        state = pagerState,
        pageCount = movies.size,
        contentPadding = PaddingValues(start = 32.dp, end = 32.dp),
    ) { page ->
        val isSelected = pagerState.currentPage == page
        val scale = if (isSelected) 1f else .8f

        Column(
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer {
                    scaleY = scale
                },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .fillMaxWidth(fraction = 0.85f)
                    .aspectRatio(0.75f)
                    .clickable (onClick = onClick)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(model = movies[page].imageUrl),
                    contentDescription = "Movie Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }

            SpacerVertical32()

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_access_time_24),
                    contentDescription = "Time Icon",
                    tint = Color.LightGray
                )
                SpacerHorizontal4()
                Text(
                    text = movies[page].time,
                    fontSize = 16.sp,
                    fontFamily = Sans,
                    fontWeight = FontWeight.Normal
                )
            }

           SpacerVertical16()

            Text(
                text = movies[page].movieName,
                fontSize = 28.sp,
                fontFamily = Sans,
                maxLines = 2,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center
            )

            SpacerVertical16()

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                val categories = movies[page].category
                categories.forEach {
                    DefaultChips(text = it.categoryName)
                }
            }
        }
    }
    }


