package com.monkeymantech.archnemesis.model

import com.prof.rssparser.Channel

data class NewsFeedState(
    val loading: Boolean = false,
    val channel: Channel? = null
)