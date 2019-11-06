package com.claire.composetest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.Clip
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.res.imageResource
import androidx.ui.text.style.TextOverflow
import androidx.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsStory()
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun NewsStory() {
    val image = +imageResource(R.drawable.header)

    MaterialTheme() {
        Column(crossAxisSize = LayoutSize.Expand, modifier = Spacing(16.dp)) {
            Container(expanded = true, height = 180.dp) {
                Clip(shape = RoundedCornerShape(8.dp)) {
                    DrawImage(image)
                }
            }

            HeightSpacer(height = 16.dp)

            Text("A day wandering through the sandhills in Shark", maxLines = 2, overflow = TextOverflow.Ellipsis, style = (+themeTextStyle { h6 }).withOpacity(0.87f))
            Text("Davenport, California", style = (+themeTextStyle { subtitle1 }).withOpacity(0.87f))
            Text("December 2018", style = (+themeTextStyle { body2 }).withOpacity(0.6f))

            HeightSpacer(height = 16.dp)

            Row {
                Button(text = "Open", style = ContainedButtonStyle())
                Button(text = "Dismiss", style = TextButtonStyle())
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    NewsStory()
}
