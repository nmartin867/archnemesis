package com.monkeymantech.archnemesis.ui.theme

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import com.monkeymantech.archnemesis.R

val NerdFamily = FontFamily(
   Font(R.font.nerd_font_sybols)
)

@Preview
@Composable
fun PreviewFontAwesome() {
    Text(text = "\uf004", fontFamily = NerdFamily)
}