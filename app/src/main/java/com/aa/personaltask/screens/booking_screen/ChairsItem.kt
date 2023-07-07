package com.aa.personaltask.screens.booking_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.aa.personaltask.R
import com.aa.personaltask.ui.theme.Primary

@Composable
fun ChairItem(rotation: Float) {
    var chair1Color by remember { mutableStateOf(Color.White) }
    var chair2Color by remember { mutableStateOf(Color.White) }
    var containerColor by remember { mutableStateOf(Color.Gray) }

    ConstraintLayout(
        modifier = Modifier
            .size(40.dp)
            .rotate(rotation)
    ) {
        val (chair1, chair2, container) = createRefs()

        Icon(
            modifier = Modifier
                .size(40.dp)
                .constrainAs(chair1) {
                    bottom.linkTo(container.bottom, margin = 4.dp)
                    start.linkTo(container.start, margin = 4.dp)
                    end.linkTo(chair2.start, margin = 4.dp)
                }
                .clickable {
                    chair1Color = when (chair1Color) {
                        Color.White -> Primary
                        Primary -> Color.Gray
                        Color.Gray -> Color.White
                        else -> {
                            Color.White
                        }
                    }
                    containerColor = if (chair1Color == Primary || chair2Color == Primary) {
                       Primary
                    } else {
                        Color.Gray
                    }
                },
            painter = painterResource(id = R.drawable.seat),
            contentDescription = "",
            tint = chair1Color
        )

        Icon(
            modifier = Modifier
                .size(40.dp)
                .constrainAs(chair2) {
                    bottom.linkTo(container.bottom, margin = 4.dp)
                    end.linkTo(container.end)
                    start.linkTo(chair1.end)
                }
                .clickable {
                    chair2Color = when (chair2Color) {
                        Color.White -> Primary
                        Primary -> Color.Gray
                        Color.Gray -> Color.White
                        else -> {
                            Color.White
                        }
                    }
                    containerColor = if (chair1Color == Primary || chair2Color == Primary) {
                        Primary
                    } else {
                        Color.Gray
                    }
                },
            painter = painterResource(id = R.drawable.seat),
            contentDescription = "",
            tint = chair2Color
        )

        Icon(
            modifier = Modifier
                .fillMaxSize()
                .constrainAs(container) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            painter = painterResource(id = R.drawable.border),
            contentDescription = "",
            tint = containerColor
        )
    }
}
