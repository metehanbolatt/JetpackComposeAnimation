package com.metehanbolat.jetpackcomposeanimation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.metehanbolat.jetpackcomposeanimation.ui.theme.JetpackComposeAnimationTheme

@ExperimentalAnimationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeAnimationTheme {
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    var isVisible by remember { mutableStateOf(false) }
                    var isRound by remember { mutableStateOf(false) }
                    Button(
                        onClick = {
                            isVisible = !isVisible
                            isRound = !isRound
                        }
                    ) {
                        Text(text = "Toggle")
                    }

                    AnimatedContent(
                        targetState = isVisible,
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        content = {
                            if (it) {
                                Box(modifier = Modifier.background(Color.Green))
                            } else {
                                Box(modifier = Modifier.background(Color.Red))
                            }
                        },
                        transitionSpec = { slideInHorizontally(
                            initialOffsetX = { if (isVisible) it else -it }
                        ) with slideOutHorizontally(
                            targetOffsetX = { if (isVisible) -it else it }
                        ) }
                    )








                    /*
                    val transition = rememberInfiniteTransition()
                    val color by transition.animateColor(
                        initialValue = Color.Red,
                        targetValue = Color.Green,
                        animationSpec = infiniteRepeatable(
                            animation = tween(2000),
                            repeatMode = RepeatMode.Reverse
                        )
                    )
                    Box(
                        modifier = Modifier
                            .size(300.dp)
                            .background(color)
                    )

                    val transition = updateTransition(targetState = isRound, label = null)

                    val borderRadius by transition.animateInt(
                        transitionSpec = { tween(2000) },
                        label = "Border Radius",
                        targetValueByState = {
                            if (it) 100 else 0
                        }
                    )
                    val color by transition.animateColor(
                        transitionSpec = { tween(1000) },
                        label = "color",
                        targetValueByState = {
                            if (it) Color.Green else Color.Red
                        }
                    )

                    AnimatedVisibility(
                        visible = isVisible,
                        enter = slideInHorizontally() + fadeIn(),
                        modifier = Modifier.fillMaxWidth().weight(1f)
                    ) {
                        Box(modifier = Modifier.background(Color.Red))
                    }
                    */
                }
            }
        }
    }
}
