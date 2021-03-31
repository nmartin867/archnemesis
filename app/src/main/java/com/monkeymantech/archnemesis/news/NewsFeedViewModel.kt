package com.monkeymantech.archnemesis.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.monkeymantech.archnemesis.ApplicationConfiguration
import com.prof.rssparser.Channel
import com.prof.rssparser.Parser
import kotlinx.coroutines.launch

class NewsFeedViewModel(private val parser: Parser, private val config: ApplicationConfiguration) :
    ViewModel() {
    private val _state = MutableLiveData(NewsFeedState())
    val state: LiveData<NewsFeedState> = _state

    fun loadNewsFeed() = viewModelScope.launch {
        try {
            _state.value = NewsFeedState(loading = true)
            val newsFeed = parser.getChannel(config.feedUrl)
            _state.value = NewsFeedState(loading = false, newsFeed)
        } catch (ex: Throwable) {
            //TODO: Crashlytics
            _state.value = NewsFeedState(loading = false)
        }
    }

    data class NewsFeedState(
        val loading: Boolean = false,
        val channel: Channel? = null
    )
}