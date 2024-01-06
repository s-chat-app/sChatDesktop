package indi.midreamsheep.schatapp.desktop.ui.homepage.sidebar.subsiderbar.selectitems

import androidx.compose.runtime.Composable


interface SelectListItem {

    fun getComposeFun(): @Composable () -> Unit
}