package indi.midreamsheep.schatapp.desktop.ui.homepage.sidebar.searchbox

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.input.key.Key
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.unit.dp
import indi.midreamsheep.schatapp.desktop.context.SChatApplicationContext
import indi.midreamsheep.schatapp.desktop.data.runtime.variable.GlobalInfo
import indi.midreamsheep.schatapp.desktop.ui.controller.sidebar.ChannelListControllerOE
import indi.midreamsheep.schatapp.desktop.ui.homepage.sidebar.selectlist.SelectListItem
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.awt.List
import java.net.URL
import java.util.LinkedList

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun chattyTopBar(){
    //保持搜索栏内容
    val searchState = remember { mutableStateOf("") }
    val focusRequester = remember { FocusRequester() }
    // 创建一个状态，用于存储输入框是否被选中
    var isFocused by remember { mutableStateOf(false) }
    //输入框
    BasicTextField(
        value = searchState.value,
        onValueChange = {
            searchState.value = it
        },
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .clip(RoundedCornerShape(4.dp,4.dp,4.dp,4.dp))
            .background(Color(199, 232, 255))
            .focusRequester(focusRequester) // 添加 focusRequester
            .onFocusChanged { isFocused = it.isFocused } // 监听焦点变化
            .onKeyEvent {keyEvent ->
                if (isFocused && keyEvent.key == Key.Enter) {
                    search(searchState.value)
                    true
                } else {
                    false
                }
            }
        ,
        decorationBox = { innerTextField ->
            Row (
                verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 2.dp, horizontal = 8.dp)
            ){
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = null,
                )
                Box(Modifier.fillMaxWidth()){
                    innerTextField()
                    if (searchState.value.isEmpty()){
                        androidx.compose.material.Text(
                            text = "Search",
                            style = MaterialTheme.typography.body1,
                            color = Color(197, 197, 197)
                        )
                    }
                }

            }
        }
    )
}

@OptIn(DelicateCoroutinesApi::class)
fun search(value: String) {
    //建立协程
    GlobalScope.launch {
        //发送搜索请求
        val result:MutableList<String> = mutableListOf()
        for (i in 0..10) {
            val readText = URL("https://v1.hitokoto.cn/?c=f&encode=text").readText()
            result.add(readText)
        }
        val oe = SChatApplicationContext.getApplicationContext().getBean(ChannelListControllerOE::class.java)
        val globalInfo = SChatApplicationContext.getApplicationContext().getBean(GlobalInfo::class.java)
        globalInfo.sideBarSelectionType.set(1)
        oe.chatChannelObservableEmitter.onNext (Test(result) )
    }
}
