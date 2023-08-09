package indi.midreamsheep.schatapp.desktop.ui.homepage.composition.list

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.sharp.Search
import androidx.compose.material.icons.twotone.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun ChatList(modifier: Modifier) {
    Column(modifier, horizontalAlignment = Alignment.Start) {
        Spacer(modifier = Modifier.height(8.dp))
        var text by rememberSaveable { mutableStateOf("") }
        TextField(
            //设置颜色
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color(0xff4D444C),
            ),
            value = text,
            onValueChange = { text = it },
            singleLine = true,
            leadingIcon = {
                Image(
                    painterResource("icon/search.png"), contentDescription = "Search",
                    modifier = Modifier.clickable { text = "" }.size(17.5.dp)
                )
            },
            shape = RoundedCornerShape(24.dp),
            modifier = Modifier.onPreviewKeyEvent {
                when {
                    (it.key == Key.Enter && it.type == KeyEventType.KeyUp) -> {
                        text = ""
                        true
                    }
                    else -> false
                }
            }.size(width = 260.dp, height = 50.dp))
        Column(
            Modifier.weight(1f).verticalScroll(rememberScrollState())
        ){
            for (i in 1..10) {

                Column(
                    Modifier.padding(10.dp).clickable {

                    }
                ){
                    Text("#main", fontSize = 15.sp, color = Color(0xffE8E0E4), modifier = Modifier.padding(bottom = 5.dp))
                    Text("chat_info", fontSize = 15.sp, color = Color(0xffE8E0E4))
                }
            }
        }
    }
}