package es.schsebastian.composemastering.basiccanvas

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import es.schsebastian.composemastering.base.BaseContent

@Composable
fun MyCanvas() {
    Canvas(
        modifier = Modifier
            .padding(20.dp)
            .size(300.dp)
    ) {
        drawRect(
            color = Color.Black,
            size = size
        )
        drawRect(
            color = Color.Red,
            topLeft = Offset(100f, 100f),
            size = Size(100f, 100f),
            style = Stroke(
                width = Stroke.HairlineWidth
            )
        )
        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(Color.Yellow, Color.Cyan),
                center = center,
                radius = 60f
            ),
            radius = 50f
        )
        drawArc(
            color = Color.Blue,
            startAngle = 0f,
            sweepAngle = 270f,
            useCenter = true,
            topLeft = Offset(100f, 500f),
            size = Size(200f, 200f),
            style = Stroke(
                width = 3.dp.toPx()
            )
        )
        drawOval(
            color = Color.Magenta,
            topLeft = Offset(30f, 450f),
            size = Size(130f, 60f),
            style = Stroke(
                width = 3.dp.toPx()
            )
        )
        drawLine(
            color = Color.Cyan,
            start = Offset(300f, 700f),
            end = Offset(700f, 700f),
            strokeWidth = 3.dp.toPx()
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)

@Composable
fun GreetingPreview() {
    BaseContent{ MyCanvas() }
}