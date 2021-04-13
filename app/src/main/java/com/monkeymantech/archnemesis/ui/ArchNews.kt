package com.monkeymantech.archnemesis.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.monkeymantech.archnemesis.model.NewsFeedState

@Composable
fun ArchNews(newsState: NewsFeedState, navController: NavHostController) {
    if(newsState.loading){
        ArchLoadingModal()
    } else {
        newsState.channel?.let { feedChan ->
            LazyColumn {
                items(feedChan.articles){ article ->
                    NewsCard(article = article)
                }
            }
        }
    }
}
