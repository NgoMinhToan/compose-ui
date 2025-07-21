package com.example.project1.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation3.runtime.NavBackStack
import com.example.project1.R
import com.example.project1.ScreenNav3
import com.example.project1.ui.theme.Project1Theme

@Composable
fun Screen2(modifier: Modifier = Modifier, navBackStack: NavBackStack) {
    Project1Theme {
        Screen2Body(
            modifier = modifier,
            onNextClicked = {
                navBackStack.add(ScreenNav3.Home)
            }
        )
    }
}


@Composable
fun Screen2Body(modifier: Modifier = Modifier, onNextClicked: () -> Unit = {}) {
    val bannerImage = painterResource(R.drawable.ic_task_completed)

    Box {
        Column(
            modifier = modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth(),
                painter = bannerImage,
                contentDescription = null,
            )
            Text(
                modifier = Modifier.padding(top = 24.dp, bottom = 8.dp),
                fontWeight = FontWeight.Bold,
                text = "All tasks completed"
            )
            Text(
                fontSize = 16.sp,
                text = "Nice work!"
            )
        }
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .align(Alignment.BottomEnd)
        ) {
            Button(
                onClick = onNextClicked,
                modifier = Modifier.align(Alignment.BottomEnd)
            ) {
                Text(text = "Next")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewScreen2() {
    Project1Theme {
        Screen2Body()
    }

}

