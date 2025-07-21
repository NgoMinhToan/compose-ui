package com.example.project1.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation3.runtime.NavBackStack
import com.example.project1.R
import com.example.project1.ScreenNav3
import com.example.project1.ui.theme.Project1Theme

@Composable
fun Screen1(modifier: Modifier = Modifier,navBackStack: NavBackStack) {
    Project1Theme {
        Screen1Body(
            modifier = modifier,
            onNextClicked = {
                navBackStack.add(ScreenNav3.Screen2)
            }
        )
    }
}

@Composable
fun Screen1Body(modifier: Modifier = Modifier, onNextClicked: () -> Unit = {}) {
    val bannerImage = painterResource(R.drawable.bg_compose_background)
    Column (
        modifier = modifier
            .fillMaxSize(),
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth(),
            painter = bannerImage,
            contentDescription = null,
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextTitle(
            content = "Jetpack Compose tutorial"
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextContent(
            content = "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs."
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextContent(
            content = "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app\\'s UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI\\'s construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name."
        )
        Spacer(modifier = Modifier.height(32.dp))
        Button (
            modifier = Modifier.align(Alignment.CenterHorizontally),
            onClick = onNextClicked,
        ) {
            Text(text = "Next")
        }
    }
}

@Composable
fun TextTitle (modifier: Modifier = Modifier, content: String) {
    Text(
        modifier = modifier
            .padding(horizontal = 16.dp),
        fontSize = 24.sp,
        text = content
    )
}

@Composable
fun TextContent (modifier: Modifier = Modifier, content: String) {
    Text(
        modifier = modifier.padding(horizontal = 16.dp),
        text = content
    )
}


@Preview(showBackground = true)
@Composable
fun PreviewScreen1() {
    Project1Theme {
        Screen1Body()
    }

}

