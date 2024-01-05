package indi.midreamsheep.schatapp.desktop.ui.homepage.sidebar.selectlist

import androidx.compose.runtime.Composable


interface SelectListItem {

    fun getComposeFun(): @Composable () -> Unit
}