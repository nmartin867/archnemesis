package com.monkeymantech.archnemesis.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.monkeymantech.archnemesis.ApplicationConfiguration
import com.monkeymantech.archnemesis.model.NewsFeedState
import com.prof.rssparser.Parser
import kotlinx.coroutines.launch

class ArchNewsViewModel(private val parser: Parser, private val config: ApplicationConfiguration) :
    ViewModel() {
    private val _newsState = MutableLiveData<NewsFeedState>()
    val newsState: LiveData<NewsFeedState> = _newsState

    fun loadNewsFeed() = viewModelScope.launch {
        try {
            _newsState.value = NewsFeedState(loading = true)
            val newsFeed = parser.getChannel(config.feedUrl)
            _newsState.value = NewsFeedState(loading = false, newsFeed)
        } catch (ex: Throwable) {
            //TODO: Crashlytics
            _newsState.value = NewsFeedState(loading = false)
        }
    }

}