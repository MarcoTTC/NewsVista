package br.com.marcottc.newsvista.view.compose

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.marcottc.newsvista.ui.theme.NewsVistaTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsVistaAppBar(
    modifier: Modifier = Modifier,
    menuButtonOnClick: () -> Unit = {},
    searchButtonOnClick: () -> Unit = {}
) {
    TopAppBar(
        modifier = modifier,
        title = {
            Text(text = "NewsVista")
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