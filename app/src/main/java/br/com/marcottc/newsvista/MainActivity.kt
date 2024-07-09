package br.com.marcottc.newsvista

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.marcottc.newsvista.model.TopArticleRemote
import br.com.marcottc.newsvista.model.mock.MockGenerator
import br.com.marcottc.newsvista.ui.theme.NewsVistaTheme
import br.com.marcottc.newsvista.ui.theme.lightGrey
import br.com.marcottc.newsvista.ui.theme.nearBlack

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewsVistaTheme {
                MainActivityScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsVistaAppBar() {
    TopAppBar(
        title = {
            Text(text = "NewsVista")
        },
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Navigation Menu"
                )
            }
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Search News"
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun NewsVistaAppBarPreview() {
    NewsVistaTheme {
        NewsVistaAppBar()
    }
}

@Composable
fun NewsArticleCard(
    modifier: Modifier = Modifier,
    article: TopArticleRemote
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
            Text(
                text = article.section,
                style = MaterialTheme
                    .typography
                    .labelLarge,
                color = nearBlack
            )
            Text(
                text = article.title,
                style = MaterialTheme
                    .typography
                    .titleMedium,
                color = nearBlack
            )
            Text(
                text = article.abstract,
                style = MaterialTheme
                    .typography
                    .bodyLarge,
                color = lightGrey
            )
            Text(
                text = article.byline,
                style = MaterialTheme
                    .typography
                    .labelSmall,
                color = nearBlack
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NewsArticleCardPreview() {
    val articleList = MockGenerator.generateTopArticleData()
    NewsVistaTheme {
        NewsArticleCard(article = articleList[0])
    }
}

@Composable
fun NewsLandscapeLayout(
    modifier: Modifier = Modifier,
    articleList: List<TopArticleRemote>
) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Adaptive(
            minSize = 256.dp
        ),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(articleList.size) {index ->
            NewsArticleCard(article = articleList[index])
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NewsLandscapeLayoutPreview() {
    val articleList = MockGenerator.generateTopArticleData()
    NewsVistaTheme {
        NewsLandscapeLayout(articleList = articleList)
    }
}

@Composable
fun NewsPortraitLayout(
    modifier: Modifier = Modifier,
    articleList: List<TopArticleRemote>
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(articleList.size) {index ->
            NewsArticleCard(article = articleList[index])
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NewsPortraitLayoutPreview() {
    val articleList = MockGenerator.generateTopArticleData()
    NewsVistaTheme {
        NewsPortraitLayout(articleList = articleList)
    }
}

@Composable
fun MainActivityScreen(modifier: Modifier = Modifier) {
    val orientation = LocalConfiguration.current.orientation
    Scaffold(
        modifier = modifier,
        topBar = {
            NewsVistaAppBar()
        }
    ) { paddingValues ->
        when (orientation) {
            Configuration.ORIENTATION_PORTRAIT -> {
                NewsPortraitLayout(
                    modifier = Modifier.padding(paddingValues),
                    articleList = MockGenerator.generateTopArticleData()
                )
            }
            else -> {
                NewsLandscapeLayout(
                    modifier = Modifier.padding(paddingValues),
                    articleList = MockGenerator.generateTopArticleData()
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainActivityScreenPreview() {
    NewsVistaTheme {
        MainActivityScreen()
    }
}