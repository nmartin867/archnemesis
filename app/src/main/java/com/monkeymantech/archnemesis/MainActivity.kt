package com.monkeymantech.archnemesis

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.monkeymantech.archnemesis.model.NewsFeedState
import com.monkeymantech.archnemesis.navigation.Screen
import com.monkeymantech.archnemesis.navigation.navItems
import com.monkeymantech.archnemesis.ui.ArchNews
import com.monkeymantech.archnemesis.ui.ArchPackages
import com.monkeymantech.archnemesis.ui.theme.ArchNemesisTheme
import com.monkeymantech.archnemesis.viewModel.ArchNewsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private val newsViewModel: ArchNewsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        newsViewModel.loadNewsFeed()
        setContent {
            ArchNemesisTheme(darkTheme = true) {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    val newsState: NewsFeedState by newsViewModel
                        .newsState.observeAsState(NewsFeedState(loading = true))

                    Scaffold(
                        topBar = { ArchTopBar() },
                        bottomBar = { ArchNavBar(navController = navController) }
                    ) {
                        NavHost(navController, startDestination = Screen.News.route) {
                            composable(Screen.News.route) { ArchNews(newsState, navController) }
                            composable(Screen.Packages.route) { ArchPackages(navController) }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun ArchTopBar() {
    TopAppBar(
        title = {
            Text(text = stringResource(R.string.app_name))
        })
}

@Composable
private fun ArchNavBar(
    navController: NavHostController,
    onScreenSelected: ((Screen) -> Unit)? = null
) {
    BottomNavigation {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.arguments?.getString(KEY_ROUTE)
        navItems.forEach { screen ->
            BottomNavigationItem(
                icon = { Icon(Icons.Filled.Home, "News") },
                label = { Text(stringResource(screen.resourceId)) },
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo = navController.graph.startDestination
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}