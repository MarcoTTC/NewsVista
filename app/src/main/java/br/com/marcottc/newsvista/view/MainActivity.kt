package br.com.marcottc.newsvista.view

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import br.com.marcottc.newsvista.R
import br.com.marcottc.newsvista.model.remote.TopArticleRemote
import br.com.marcottc.newsvista.model.mock.MockGenerator
import br.com.marcottc.newsvista.ui.theme.NewsVistaTheme
import br.com.marcottc.newsvista.ui.theme.lightGrey
import br.com.marcottc.newsvista.ui.theme.nearBlack
import br.com.marcottc.newsvista.viewmodel.NewsVistaViewModel
import coil.compose.AsyncImage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val viewmodel by viewModels<NewsVistaViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch(Dispatchers.IO) {
            viewmodel.fetchTopArticles()
        }

        enableEdgeToEdge()
        setContent {
            val newsRetrievalState: NewsRetrievalState by viewmodel.currentNewsRetrievalState
                .collectAsState(initial = NewsRetrievalState())

            NewsVistaTheme {
                MainActivityScreen(newsRetrievalState = newsRetrievalState)
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
                IconButton(onClick = {
                    lifecycleScope.launch(Dispatchers.IO) {
                        viewmodel.fetchTopArticles()
                    }
                }) {
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
                    model = newsArticle.multimediaList[1].url,
                    contentDescription = null,
                    placeholder = painterResource(R.drawable.placeholder_image)
                )
                Text(
                    text = newsArticle.section,
                    style = MaterialTheme
                        .typography
                        .labelLarge,
                    color = nearBlack
                )
                Text(
                    text = newsArticle.title,
                    style = MaterialTheme
                        .typography
                        .titleMedium,
                    color = nearBlack
                )
                Text(
                    text = newsArticle.abstract,
                    style = MaterialTheme
                        .typography
                        .bodyLarge,
                    color = lightGrey
                )
                Text(
                    text = newsArticle.byline,
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
        val mockArticle = MockGenerator.generateTopArticleData()[0]
        NewsVistaTheme {
            NewsArticleCard(newsArticle = mockArticle)
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
            items(articleList.size) { index ->
                NewsArticleCard(newsArticle = articleList[index])
            }
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
            items(articleList.size) { index ->
                NewsArticleCard(newsArticle = articleList[index])
            }
        }
    }

    @Composable
    fun MainActivityScreen(
        modifier: Modifier = Modifier,
        newsRetrievalState: NewsRetrievalState
    ) {
        val orientation = LocalConfiguration.current.orientation
        Scaffold(
            modifier = modifier,
            topBar = {
                NewsVistaAppBar()
            }
        ) { paddingValues ->
            when (orientation) {
                Configuration.ORIENTATION_PORTRAIT -> {
                    when (newsRetrievalState.getState()) {
                        NewsRetrievalState.State.LOADING -> {
                            CircularProgressIndicator()
                        }
                        NewsRetrievalState.State.SUCCESS -> {
                            NewsPortraitLayout(
                                modifier = Modifier.padding(paddingValues),
                                articleList = newsRetrievalState.getNewsRetrieval()!!.resultList
                            )
                        }
                        NewsRetrievalState.State.ERROR -> {
                            Text(text = newsRetrievalState.getErrorMessage()!!)
                        }
                    }
                }
                else -> {
                    when (newsRetrievalState.getState()) {
                        NewsRetrievalState.State.LOADING -> {
                            CircularProgressIndicator()
                        }
                        NewsRetrievalState.State.SUCCESS -> {
                            NewsLandscapeLayout(
                                modifier = Modifier.padding(paddingValues),
                                articleList = newsRetrievalState.getNewsRetrieval()!!.resultList
                            )
                        }
                        NewsRetrievalState.State.ERROR -> {
                            Text(text = newsRetrievalState.getErrorMessage()!!)
                        }
                    }
                }
            }
        }
    }

    @PreviewScreenSizes
    @Composable
    fun ScreenPreview() {
        val newsRetrieval = MockGenerator.generateNewsRetrievalData()

        NewsVistaTheme {
            MainActivityScreen(newsRetrievalState = NewsRetrievalState(
                state = NewsRetrievalState.State.SUCCESS,
                newsRetrieval = newsRetrieval
            ))
        }
    }
}