package com.monkeymantech.archnemesis.ioc

import com.monkeymantech.archnemesis.ApplicationConfiguration
import com.monkeymantech.archnemesis.news.NewsFeedViewModel
import com.prof.rssparser.Parser
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import java.nio.charset.Charset

val configuration = module {
    single { ApplicationConfiguration() }
}

val news = module {
    single {
        Parser.Builder()
            .context(androidContext())
            .charset(Charset.forName("ISO-8859-7"))
            .cacheExpirationMillis(24L * 60L * 60L * 100L) // one day
            .build()
    }

    viewModel { NewsFeedViewModel(get(), get()) }
}