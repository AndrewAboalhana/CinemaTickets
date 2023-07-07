package com.aa.personaltask.screens.booking_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
 fun CinemaChairs() {
    val chairs = remember { listOf("", "", "", "", "", "", "", "", "", "", "","","","","") }

    LazyVerticalGrid(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        columns = GridCells.Fixed(count = 3)
    ) {
        itemsIndexed(chairs) { index, _ ->
            val rotation = when (index % 3) {
                0 -> 10f
                1 -> 0f
                2 -> -10f
                else -> 0f
            }
            ChairItem(rotation)
        }
    }
}