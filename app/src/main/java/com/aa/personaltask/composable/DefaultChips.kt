package com.aa.personaltask.composable

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.aa.personaltask.ui.theme.SecondaryBlack

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultChips(text: String) {
    AssistChip(
        onClick = {},
        label = {
            Text(
                text = text,
                color = SecondaryBlack,
            )
        },
        shape = RoundedCornerShape(16.dp),
        enabled = false
    )
    SpacerHorizontal4()
}
