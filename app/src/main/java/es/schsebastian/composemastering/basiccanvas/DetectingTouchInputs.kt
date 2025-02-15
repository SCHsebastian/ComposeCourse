package es.schsebastian.composemastering.basiccanvas

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import es.schsebastian.composemastering.base.BaseContent
import es.schsebastian.composemastering.misc.MegaPreview
import es.schsebastian.composemastering.misc.PhonePreviews
import es.schsebastian.composemastering.misc.TabletPreviews
import kotlinx.coroutines.delay
import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.math.sqrt
import kotlin.random.Random

@Composable
fun DetectingTouchInputs() {
    var points by remember {
        mutableStateOf(0)
    }
    var isTimerRunning by remember {
        mutableStateOf(false)
    }
    var ballColor by remember {
        mutableStateOf(Color.Blue)
    }
    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Points: $points",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Green,
                modifier = Modifier.weight(1f).align(Alignment.CenterVertically)
            )
            Button(
                modifier = Modifier.weight(1f).align(Alignment.CenterVertically),
                onClick = {
                    isTimerRunning = !isTimerRunning
                    points = 0
                }
            ) {
                Text(text = if(isTimerRunning) "Reset" else "Start")
            }
            CountdownTimer(
                modifier = Modifier.weight(1f).align(Alignment.Top),
                isTimerRunning = isTimerRunning
            ) {
                isTimerRunning = false
            }
        }
        BallClicker(
            ballColor = ballColor,
            enabled = isTimerRunning
        ) {
            points++
            ballColor = randomColor()
        }
    }
}

@Composable
fun CountdownTimer(
    modifier: Modifier,
    time: Int = 30000,
    isTimerRunning: Boolean = false,
    onTimerEnd: () -> Unit = {}
) {
    var curTime by remember {
        mutableStateOf(time)
    }
    LaunchedEffect(key1 = curTime, key2 = isTimerRunning) {
        if(!isTimerRunning) {
            curTime = time
            return@LaunchedEffect
        }
        if(curTime > 0) {
            delay(1000L)
            curTime -= 1000
        } else {
            onTimerEnd()
        }
    }
    Box(modifier){
        Text(
            text = (curTime / 1000).toString(),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterEnd),
            color = Color.Red
        )
    }

}

@Composable
fun BallClicker(
    radius: Float = 100f,
    enabled: Boolean = false,
    ballColor: Color = Color.Red,
    onBallClick: () -> Unit = {}
) {
    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        var ballPosition by remember {
            mutableStateOf(
                centerOfScreen(constraints.maxWidth, constraints.maxHeight)
            )
        }
        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(enabled) {
                    if (!enabled) {
                        return@pointerInput
                    }
                    detectTapGestures {
                        val distance = sqrt(
                            (it.x - ballPosition.x).pow(2) +
                                    (it.y - ballPosition.y).pow(2)
                        )
                        if (distance <= radius) {
                            ballPosition = randomOffset(
                                radius = radius,
                                width = constraints.maxWidth,
                                height = constraints.maxHeight
                            )
                            onBallClick()
                        }
                    }
                }
        ) {
            drawCircle(
                color = ballColor,
                radius = radius,
                center = ballPosition
            )
        }
    }
}

private fun centerOfScreen(maxWidth: Int, maxHeight: Int): Offset = Offset(
    x = maxWidth / 2f,
    y = maxHeight / 2f
)

private fun randomColor() = Color(
    Random.nextFloat(),
    Random.nextFloat(),
    Random.nextFloat(),
    1f
)

private fun randomOffset(radius: Float, width: Int, height: Int): Offset = Offset(
    x = Random.nextInt(radius.roundToInt(), width - radius.roundToInt()).toFloat(),
    y = Random.nextInt(radius.roundToInt(), height - radius.roundToInt()).toFloat()
)

@MegaPreview
@PhonePreviews
@TabletPreviews
@Composable
private fun PreviewDetectingTouchInputs() {
    BaseContent {
        DetectingTouchInputs()
    }
}