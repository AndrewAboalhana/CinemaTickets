package com.aa.personaltask.screens.booking_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookingChips(
    firstText: String,
    secondText: String? = null,
) {
    var isSelected by remember { mutableStateOf(false) }

    FilterChip(
        modifier = Modifier.wrapContentSize(),
        selected = isSelected,
        shape = RoundedCornerShape(16.dp),
        onClick = { isSelected = !isSelected },
        label = {
            Column(
                modifier = Modifier.padding(8.dp).wrapContentSize(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = firstText,
                    fontSize = 20.sp,
                    color = if (isSelected) Color.White else Color.Black
                )
                if (!secondText.isNullOrBlank()) {
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = secondText,
                        textAlign = TextAlign.Center,
                        fontSize = 16.sp,
                        color = Color.LightGray
                    )
                }
            }
        },
        colors = FilterChipDefaults.filterChipColors(
            selectedContainerColor = Color(0xFF9D8F82),
            disabledContainerColor = Color.Transparent,
            selectedLabelColor = Color.White,
            disabledLabelColor = Color.Black
        ),
        border = FilterChipDefaults.filterChipBorder(
            borderColor = Color.LightGray
        )
    )
}

@Preview
@Composable
fun PreviewBookingChips() {
    BookingChips(firstText = "16", secondText = "Mon")
}