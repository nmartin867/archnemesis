package com.monkeymantech.archnemesis.navigation

import androidx.annotation.StringRes
import com.monkeymantech.archnemesis.R

sealed class Screen(val route: String, @StringRes val resourceId: Int) {
    object News : Screen("news", R.string.news)
    object Packages : Screen("packages", R.string.packages)
}

val navItems = listOf(Screen.News, Screen.Packages)