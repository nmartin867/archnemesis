package com.monkeymantech.archnemesis.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.prof.rssparser.Article

@Composable
fun NewsCard(article: Article, modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { /* onClick */ }
        ) {
            val padding = Modifier.padding(horizontal = 16.dp)
            Text(
                text = article.title ?: "",
                style = MaterialTheme.typography.h6,
                modifier = padding
            )
            Text(
                text = article.author ?: "",
                style = MaterialTheme.typography.body2,
                modifier = padding
            )
            //PostMetadata(post, padding)
            Spacer(Modifier.height(16.dp))
        }
    }
}