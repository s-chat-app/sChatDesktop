package indi.midreamsheep.schatapp.desktop.ui.homepage.sidebar.subsiderbar.selectitems

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import indi.midreamsheep.schatapp.desktop.context.SChatApplicationContext
import indi.midreamsheep.schatapp.desktop.ui.controller.sidebar.ChannelListController
import indi.midreamsheep.schatapp.desktop.ui.homepage.sidebar.subsiderbar.SubSideBarFun

class SelectList : SubSideBarFun {
    override fun getComposeFun(): @Composable () -> Unit {
        return {
            val list = SChatApplicationContext.getApplicationContext().getBean(ChannelListController::class.java).list
            LazyColumn {
                items(list.size){
                    list[it].getComposeFun()()
                }
            }
        }
    }
}