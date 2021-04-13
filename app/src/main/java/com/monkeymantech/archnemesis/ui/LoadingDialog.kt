package com.monkeymantech.archnemesis.ui

import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import com.monkeymantech.archnemesis.ui.theme.ArchNemesisTheme


@Composable
fun ArchLoadingModal() {
    ArchNemesisTheme {
        LinearProgressIndicator()
    }
}