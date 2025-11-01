package br.com.marcottc.newsvista.view.compose

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.marcottc.newsvista.ui.theme.NewsVistaTheme

@Composable
fun NewsTagSmallPortraitLayout(
    modifier: Modifier = Modifier,
    newsTag: String
) {
    Text(
        modifier = modifier,
        text = newsTag
    )
}

@Preview(showBackground = true)
@Composable
fun NewsTagSmallPortraitLayoutPreview() {
    NewsVistaTheme {
        NewsTagSmallPortraitLayout(
            modifier = Modifier.padding(all = 8.dp),
            newsTag = "#TechDesign"
        )
    }
}

@Composable
fun VerticalDottedDivisor(
    modifier: Modifier = Modifier
) {
    val pathEffect = remember { PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f) }
    Canvas(
        modifier = modifier.width(2.dp)
    ) {
        drawLine(
            color = Color.Gray,
            start = Offset(0f, 0f),
            end = Offset(0f, size.height),
            pathEffect = pathEffect
        )
    }
}

@Preview(showBackground = true)
@Composable
fun VerticalDottedDivisorPreview() {
    NewsVistaTheme {
        Box(modifier = Modifier.height(100.dp).padding(all = 8.dp)) {
            VerticalDottedDivisor(modifier = Modifier.fillMaxHeight())
        }
    }
}