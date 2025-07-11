package com.example.project1

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.example.project1.nav3.Navigation3
import com.example.project1.ui.theme.Project1Theme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.auto(
                Color.Transparent.toArgb(),
                Color.Transparent.toArgb()
            ),
            navigationBarStyle = SystemBarStyle.auto(  // ✨ chuyển sang light
                Color.Transparent.toArgb(),
                Color.Transparent.toArgb()
            )
        )
        if (Build.VERSION.SDK_INT >= 29) {
            window.isNavigationBarContrastEnforced = false
        }
        setContent {
            Project1Theme {
                Navigation3()
//                Navigation()

//                val snackbarHostState = remember { SnackbarHostState() }
//                Scaffold(
//                    snackbarHost = { SnackbarHost(snackbarHostState) },
//                    modifier = Modifier
//                        .fillMaxSize()
//                ) { innerPadding ->
//                    Box (
//                        contentAlignment = Alignment.Center,
//                    ){
//                        CardList(innerPadding)
//                        ButtonInputSnackBar(innerPadding, snackbarHostState)
//                        TestConstraintLayout()
//                    }
//
//                }
            }
        }
    }
}


@Composable
fun CardList(contentPadding: PaddingValues = PaddingValues()) {
    val state = rememberLazyListState()

    LazyColumn (
        state = state,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize(),
        contentPadding = contentPadding
    ) {
        itemsIndexed(listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")) { index, item ->
            MyCard(title = item)
        }
        items(5) { index ->
            MyCard(title = "Card #$index")
        }
    }
}

@Composable
fun MyCard(
    title: String,
    modifier: Modifier = Modifier
) {
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val color = remember { mutableStateOf(Color(0xFFB3E5FC)) }
    Card (
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = modifier
            .padding(16.dp)
            .height(screenHeight*0.7f)
            .width(screenWidth*0.8f)
    ){
        Box(modifier = Modifier
            .fillMaxSize()
            .align(Alignment.CenterHorizontally)
            .clickable {
                color.value = Color(
                    Random.nextFloat(),
                    Random.nextFloat(),
                    Random.nextFloat(),
                    1f
                )
            },
            contentAlignment = Alignment.Center,
        ){
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .background(
                        Brush.radialGradient(
                            colors = listOf(
                                color.value.copy(alpha = 0.5f),
                                Color.Transparent
                            ),
                            radius = 500f
                        )
                    )
            )
            Text(
                buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Color(0xFFB3E5FC),
                            fontSize = 30.sp
                        )
                    ) {
                        append(title)
                    }
                    append(title)
                    withStyle(
                        style = SpanStyle(
                            color = Color.Red,
                            fontSize = 24.sp,
                            textDecoration = TextDecoration.LineThrough
                        )
                    ) {
                        append(title)
                    }
                    append(title)
                } ,
                modifier = Modifier
                .align(Alignment.Center),
//                fontFamily = eduFamily,
                style = MaterialTheme.typography.bodyLarge,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline
            )
        }
    }
}



@Composable
private fun ButtonInputSnackBar(
    innerPadding: PaddingValues,
    snackbarHostState: SnackbarHostState
) {
    var textFieldState by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()
    Box(
        modifier = Modifier
            .width(300.dp)
            .height(250.dp)
            .background(Color(0x30D826DE))
            .padding(innerPadding)
            .padding(16.dp)
    ) {
        Column {
            TextField(
                value = textFieldState,
                label = ({ Text("Name") }),
                onValueChange = {
                    textFieldState = it
                },
            )
            Button(
                onClick = {
                    scope.launch {
                        snackbarHostState.currentSnackbarData?.dismiss()
                        snackbarHostState.showSnackbar(
                            message = "Hello $textFieldState"
                        )
                    }
                    scope.launch {
                        textFieldState = ""
                    }
                }
            ) { Text("Submit") }.toString()

        }
    }

}



@Composable
fun TestConstraintLayout() {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val maxDp = screenWidth*0.9f
    val gridSize = maxDp/4
    var rightBoxSize by remember { mutableStateOf(0.dp) }
    val rightBoxHeightDp by animateDpAsState(
        targetValue = rightBoxSize,
        animationSpec = spring(Spring.DampingRatioHighBouncy, stiffness = Spring.StiffnessMedium)
    )
    val infiniteTransition = rememberInfiniteTransition()
    val color by infiniteTransition.animateColor(
        initialValue = Color.Red,
        targetValue = Color.Green,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    LaunchedEffect(true) {
        delay(1000)
        rightBoxSize = gridSize
    }
    val constraints = ConstraintSet {
        val redBox = createRefFor("redBox")
        val greenBox = createRefFor("greenBox")
        val guidelineHorizontalStart = createGuidelineFromStart(0.05f)
        val guidelineHorizontalEnd = createGuidelineFromEnd(0.05f)
        val guidelineVerticalTop = createGuidelineFromTop(0.1f)
        constrain(redBox) {
            top.linkTo(guidelineVerticalTop)
            start.linkTo(guidelineHorizontalStart)
            width = Dimension.value(rightBoxHeightDp)
            height = Dimension.value(rightBoxHeightDp)
        }
        constrain(greenBox) {
            top.linkTo(guidelineVerticalTop)
            start.linkTo(redBox.end)
            end.linkTo(guidelineHorizontalEnd)
            width = Dimension.fillToConstraints
            height = Dimension.value(rightBoxHeightDp)
        }
    }
    ConstraintLayout(
        constraints,
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .background(color)
                .layoutId("redBox")
                .clickable {
                    when (rightBoxSize) {
                        gridSize -> rightBoxSize = gridSize * 2
                        gridSize * 2 -> rightBoxSize = gridSize * 3
                        else -> rightBoxSize = gridSize
                    }
                }
            ,
        )
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(28.dp))
                .background(Color.Red)
                .padding(4.dp)
                .clip(RoundedCornerShape(24.dp))
                .background(Color.Blue)
                .padding(4.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(Color.Green)
                .layoutId("greenBox")
        )
    }
}





@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Project1Theme {
        Greeting("Android")
    }
}