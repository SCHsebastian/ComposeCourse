package es.schsebastian.composemastering

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import es.schsebastian.composemastering.base.BaseContent
import es.schsebastian.composemastering.basiccanvas.DetectingTouchInputs

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BaseContent {
                DetectingTouchInputs()
            }
        }
    }
}
