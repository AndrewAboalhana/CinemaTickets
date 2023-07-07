package com.aa.personaltask.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.aa.personaltask.R
import com.aa.personaltask.ui.theme.Primary

@Composable
fun HomeNavBar(){
    Box(
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CustomButton(
                painter = R.drawable.outline_movie_24,
                modifier = Modifier.size(48.dp),
                backgroundColor = Primary
            ) {}
            CustomButton(
                painter = R.drawable.outline_search_24,
                modifier = Modifier.size(48.dp),
                iconTint = Color.Gray,
                backgroundColor = Color.Transparent
            ) {}
            CustomButton(
                painter = R.drawable.baseline_credit_card_24,
                modifier = Modifier.size(48.dp),
                iconTint = Color.Gray,
                backgroundColor = Color.Transparent
            ) {}
            CustomButton(
                painter = R.drawable.outline_person_24,
                modifier = Modifier.size(48.dp),
                iconTint = Color.Gray,
                backgroundColor = Color.Transparent
            ) {}
        }
    }
}