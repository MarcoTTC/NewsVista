package br.com.marcottc.newsvista.view

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import br.com.marcottc.newsvista.intent.NewsRetrievalIntent
import br.com.marcottc.newsvista.model.mock.MockGenerator
import br.com.marcottc.newsvista.model.remote.TopStoriesArticleRemote
import br.com.marcottc.newsvista.ui.theme.NewsVistaTheme
import br.com.marcottc.newsvista.view.compose.NewsArticleHeadlineSmallPortraitLayout
import br.com.marcottc.newsvista.view.compose.NewsArticleItemSmallPortraitLayout
import br.com.marcottc.newsvista.view.compose.NewsArticleMediumCardSmallLayout
import br.com.marcottc.newsvista.view.compose.NewsVistaAppBar
import br.com.marcottc.newsvista.state.NewsRetrievalState
import br.com.marcottc.newsvista.view.compose.HorizontalDottedDivisor
import br.com.marcottc.newsvista.view.compose.NewsTagSmallPortraitLayout
import br.com.marcottc.newsvista.view.compose.VerticalDottedDivisor
import br.com.marcottc.newsvista.viewmodel.NewsVistaViewModel

class MainActivity : ComponentActivity() {

    private val viewmodel by viewModels<NewsVistaViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewmodel.handleIntent(NewsRetrievalIntent.FETCH_ARTICLES)
        enableEdgeToEdge()
        setContent {
            val newsRetrievalState: NewsRetrievalState by viewmodel.currentNewsRetrievalState
                .collectAsStateWithLifecycle(
                    initialValue = NewsRetrievalState(),
                    minActiveState = Lifecycle.State.RESUMED
                )

            NewsVistaTheme {
                MainActivityScreen(newsRetrievalState = newsRetrievalState)
            }
        }
    }

    @Composable
    fun NewsLandscapeLayout(
        modifier: Modifier = Modifier,
        articleList: List<TopStoriesArticleRemote>
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
                NewsArticleMediumCardSmallLayout(newsArticle = articleList[index])
            }
        }
    }

    @Composable
    fun NewsPhonePortraitLayout360dp(
        modifier: Modifier = Modifier,
        tagsList: List<String>,
        articleList: List<TopStoriesArticleRemote>
    ) {
        Column(modifier = modifier) {
            LazyRow(
                modifier = Modifier.padding(all = 8.dp)
            ) {
                items(tagsList.size) { index ->
                    val verticalDivisorModifier = remember {
                        Modifier
                            .height(21.dp)
                            .padding(horizontal = 8.dp)
                    }
                    val tag = tagsList[index]
                    Row(
                        modifier = Modifier.wrapContentHeight()
                    ) {
                        NewsTagSmallPortraitLayout(
                            newsTag = tag
                        )
                        VerticalDottedDivisor(modifier = verticalDivisorModifier)
                    }
                }
            }
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(articleList.size) { index ->
                    val newsItemModifier = remember { Modifier.padding(all = 8.dp) }
                    val divisorHorizontalModifier = remember { Modifier.padding(horizontal = 8.dp) }
                    val article = articleList[index]
                    if (index == 0) {
                        NewsArticleHeadlineSmallPortraitLayout(
                            modifier = newsItemModifier,
                            newsArticle = article
                        )
                    } else {
                        HorizontalDottedDivisor(modifier = divisorHorizontalModifier)
                        NewsArticleItemSmallPortraitLayout(
                            modifier = newsItemModifier,
                            newsArticle = article
                        )
                    }
                }
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
                NewsVistaAppBar(menuButtonOnClick = {
                    viewmodel.handleIntent(NewsRetrievalIntent.FETCH_ARTICLES)
                })
            }
        ) { paddingValues ->
            when (orientation) {
                Configuration.ORIENTATION_PORTRAIT -> {
                    when (newsRetrievalState.getState()) {
                        NewsRetrievalState.State.LOADING -> {
                            CircularProgressIndicator()
                        }

                        NewsRetrievalState.State.SUCCESS -> {
                            NewsPhonePortraitLayout360dp(
                                modifier = Modifier.padding(paddingValues),
                                tagsList = MockGenerator.generateNewsTagList(),
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
        val newsRetrieval = MockGenerator.generateTopStoriesNewsRetrievalData()

        NewsVistaTheme {
            MainActivityScreen(
                newsRetrievalState = NewsRetrievalState(
                    state = NewsRetrievalState.State.SUCCESS,
                    newsRetrieval = newsRetrieval
                )
            )
        }
    }
}