package br.com.marcottc.newsvista.view.compose

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.marcottc.newsvista.R
import br.com.marcottc.newsvista.model.mock.MockGenerator
import br.com.marcottc.newsvista.model.remote.TopArticleRemote
import br.com.marcottc.newsvista.ui.theme.LibreFranklin
import br.com.marcottc.newsvista.ui.theme.NewsVistaTheme
import coil.compose.AsyncImage

@Composable
fun NewsArticleHeadlineSmallPortraitLayout(
    modifier: Modifier = Modifier,
    newsArticle: TopArticleRemote
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(6f / 4f),
            model =
            if (newsArticle.multimediaList.isNullOrEmpty()) {
                null
            } else {
                newsArticle.multimediaList[1].url
            },
            contentDescription = null,
            placeholder = painterResource(R.drawable.medium_placeholder_image),
            error = painterResource(R.drawable.medium_placeholder_image),
            fallback = painterResource(R.drawable.medium_placeholder_image)
        )
        Text(
            text = newsArticle.section,
            style = MaterialTheme
                .typography
                .labelSmall
        )
        Text(
            text = newsArticle.title,
            style = TextStyle(
                fontFamily = LibreFranklin,
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp,
                letterSpacing = (0.15).sp,
                lineHeight = 27.sp
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun NewsArticleHeadlineSmallPortraitLayoutPreview() {
    val mockArticle = MockGenerator.generateTopArticleData()
    NewsVistaTheme {
        NewsArticleHeadlineSmallPortraitLayout(
            modifier = Modifier.padding(all = 8.dp),
            newsArticle = mockArticle
        )
    }
}

@Composable
fun DottedDivisor(
    modifier: Modifier = Modifier
) {
    val pathEffect = remember { PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f) }
    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .height(1.dp)
    ) {
        drawLine(
            color = Color.Gray,
            start = Offset(0f, 0f),
            end = Offset(size.width, 0f),
            pathEffect = pathEffect
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DottedDivisorPreview() {
    NewsVistaTheme {
        DottedDivisor(modifier = Modifier.padding(all = 8.dp))
    }
}

@Composable
fun NewsArticleItemSmallPortraitLayout(
    modifier: Modifier = Modifier,
    newsArticle: TopArticleRemote
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Column(
            modifier = Modifier
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                text = newsArticle.section,
                style = MaterialTheme
                    .typography
                    .labelSmall
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                text = newsArticle.title,
                style = MaterialTheme
                    .typography
                    .titleMedium
            )
        }
        AsyncImage(
            modifier = Modifier
                .align(Alignment.Top),
            model =
            if (newsArticle.multimediaList.isNullOrEmpty()) {
                null
            } else {
                newsArticle.multimediaList[2].url
            },
            contentDescription = null,
            placeholder = painterResource(R.drawable.small_placeholder_image),
            error = painterResource(R.drawable.small_placeholder_image),
            fallback = painterResource(R.drawable.small_placeholder_image)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun NewsArticleItemSmallPortraitLayoutPreview() {
    val mockArticle = MockGenerator.generateTopArticleData()
    NewsVistaTheme {
        NewsArticleItemSmallPortraitLayout(
            modifier = Modifier.padding(all = 8.dp),
            newsArticle = mockArticle
        )
    }
}

@Composable
fun NewsArticleItemSmallLandscapeLayout(
    modifier: Modifier = Modifier,
    newsArticle: TopArticleRemote
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Column(
            modifier = Modifier
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                text = newsArticle.section,
                style = MaterialTheme
                    .typography
                    .labelSmall
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                text = newsArticle.title,
                style = MaterialTheme
                    .typography
                    .titleMedium
            )
            Text(
                text = newsArticle.abstract,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme
                    .typography
                    .titleSmall,
                color = MaterialTheme
                    .colorScheme
                    .secondary
            )
        }
        AsyncImage(
            modifier = Modifier
                .align(Alignment.Top),
            model =
            if (newsArticle.multimediaList.isNullOrEmpty()) {
                null
            } else {
                newsArticle.multimediaList[2].url
            },
            contentDescription = null,
            placeholder = painterResource(R.drawable.small_placeholder_image),
            error = painterResource(R.drawable.small_placeholder_image),
            fallback = painterResource(R.drawable.small_placeholder_image)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun NewsArticleItemSmallLandscapeLayoutPreview() {
    val mockArticle = MockGenerator.generateTopArticleData()
    NewsVistaTheme {
        NewsArticleItemSmallLandscapeLayout(
            modifier = Modifier.padding(all = 8.dp),
            newsArticle = mockArticle
        )
    }
}

// TODO - This composable is still used for the landscape layout,
//        but it is soon to be updated to better reflect Fortnightly layout
@Composable
fun NewsArticleMediumCardSmallLayout(
    modifier: Modifier = Modifier,
    newsArticle: TopArticleRemote
) {
    Card(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults
            .cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(6f / 4f),
                model =
                if (newsArticle.multimediaList.isNullOrEmpty()) {
                    null
                } else {
                    newsArticle.multimediaList[1].url
                },
                contentDescription = null,
                placeholder = painterResource(R.drawable.medium_placeholder_image),
                error = painterResource(R.drawable.medium_placeholder_image),
                fallback = painterResource(R.drawable.medium_placeholder_image)
            )
            Text(
                text = newsArticle.section,
                style = MaterialTheme
                    .typography
                    .labelLarge
            )
            Text(
                text = newsArticle.title,
                style = MaterialTheme
                    .typography
                    .titleMedium
            )
            Text(
                text = newsArticle.abstract,
                style = MaterialTheme
                    .typography
                    .bodyLarge,
                color = MaterialTheme
                    .colorScheme
                    .secondary
            )
            Text(
                text = newsArticle.byline,
                style = MaterialTheme
                    .typography
                    .labelSmall
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NewsArticleMediumCardSmallLayoutPreview() {
    val mockArticle = MockGenerator.generateTopArticleData()
    NewsVistaTheme {
        NewsArticleMediumCardSmallLayout(newsArticle = mockArticle)
    }
}