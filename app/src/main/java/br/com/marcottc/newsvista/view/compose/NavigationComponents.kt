package br.com.marcottc.newsvista.view.compose

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.marcottc.newsvista.ui.theme.NewsVistaTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsVistaAppBar(
    modifier: Modifier = Modifier,
    tagsList: List<String> = emptyList(),
    menuButtonOnClick: () -> Unit = {},
    searchButtonOnClick: () -> Unit = {}
) {
    TopAppBar(
        modifier = modifier,
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "NewsVista")

                if (tagsList.isNotEmpty()) {
                    LazyRow(
                        modifier = Modifier.padding(start = 16.dp)
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
                                if (index < tagsList.size - 1) {
                                    VerticalDottedDivisor(modifier = verticalDivisorModifier)
                                }
                            }
                        }
                    }
                }
            }
        },
        navigationIcon = {
            IconButton(onClick = menuButtonOnClick) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Navigation Menu"
                )
            }
        },
        actions = {
            IconButton(onClick = searchButtonOnClick) {
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

@Preview(
    name = "AppBar with Tags",
    widthDp = 600,
    showBackground = true
)
@Composable
fun NewsVistaAppBarWithTagsPreview() {
    NewsVistaTheme {
        NewsVistaAppBar(
            tagsList = listOf("#TechDesign", "#Reform", "#HealthcareRevolution")
        )
    }
}