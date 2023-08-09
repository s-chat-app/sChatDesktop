package indi.midreamsheep.schatapp.desktop.ui.homepage.composition.chat

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.*
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@Preview
fun ChatWindow(modifier: Modifier) {
    Column (modifier){
        toolBar(Modifier.height(50.dp))
        chat(Modifier.weight(1f))
        input(Modifier.height(50.dp))
    }
}

@Composable
fun toolBar(modifier: Modifier) {
    Row(modifier) {
        //TODO 左边的信息
        Column {
            Text("chat_name", fontSize = 20.sp, modifier = Modifier.padding(bottom = 5.dp))
            Text("chat_info", fontSize = 10.sp)
        }
        Spacer(modifier = Modifier.weight(1f))
        //TODO 右边的图标
        Row (horizontalArrangement = Arrangement.End) {
            Icon(Icons.Outlined.Menu, contentDescription = "menu")
            Icon(Icons.Outlined.KeyboardArrowRight, contentDescription = "menu")
        }
    }
}

@Composable
fun chat(modifier: Modifier) {
    Column(modifier) {
        for (i in 1..10) {
            messageCard()
            messageCard(true)
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun input(modifier: Modifier) {
    Row (modifier){
        var text by rememberSaveable { mutableStateOf("") }
        TextField(
            textStyle = TextStyle(
                fontSize = 15.sp,
            ),
            value = text,
            onValueChange = { text = it },
            singleLine = true,
            modifier = Modifier.onPreviewKeyEvent {
                when {
                    (it.key == Key.Enter && it.type == KeyEventType.KeyUp) -> {
                        text = ""
                        true
                    }

                    else -> false
                }
            }.fillMaxSize().height(50.dp).weight(1f)
        )
        Icon(
            Icons.Outlined.Send,
            contentDescription = "send",
            modifier = Modifier
                .clickable { text = "" }
                .height(50.dp)
                .width(50.dp)
        )
    }
}