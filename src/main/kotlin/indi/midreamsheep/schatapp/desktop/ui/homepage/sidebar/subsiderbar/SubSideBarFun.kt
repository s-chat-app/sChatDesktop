package indi.midreamsheep.schatapp.desktop.ui.homepage.sidebar.subsiderbar

import androidx.compose.runtime.Composable

fun interface SubSideBarFun {
    fun getComposeFun(): @Composable () -> Unit
}