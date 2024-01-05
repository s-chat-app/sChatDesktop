package indi.midreamsheep.schatapp.desktop.ui.homepage.sidebar.searchbox

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import indi.midreamsheep.schatapp.desktop.ui.controller.sidebar.ChannelListControllerFun
import indi.midreamsheep.schatapp.desktop.ui.homepage.sidebar.selectlist.SelectListItem

class Test(private val result:List<String>): ChannelListControllerFun {

    @Composable
    fun searchResult(text: String){
        Surface (
            Modifier.fillMaxWidth().height(50.dp).border(1.dp, Color.Blue).background(Color.White)
        ){
            Text(text = text)
        }
    }

    override fun change(): MutableList<SelectListItem> {
        val list = mutableListOf<SelectListItem>()
        result.forEach {
            list.add(object : SelectListItem {
                override fun getComposeFun(): @Composable () -> Unit {
                    return { searchResult(it) }
                }
            })
        }
        return list
    }
}