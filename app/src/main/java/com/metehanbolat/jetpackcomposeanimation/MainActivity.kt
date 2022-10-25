package com.metehanbolat.jetpackcomposeanimation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.metehanbolat.jetpackcomposeanimation.ui.theme.JetpackComposeAnimationTheme

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
                    val borderRadius by animateIntAsState(
                        targetValue = if (isRound) 100 else 0,
                        animationSpec = tween(1000)
                    )
                    Box(
                        modifier = Modifier
                            .size(300.dp)
                            .clip(RoundedCornerShape(borderRadius))
                            .background(Color.Red)
                    )
                    /*
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
