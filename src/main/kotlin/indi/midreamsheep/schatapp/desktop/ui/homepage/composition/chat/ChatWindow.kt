package indi.midreamsheep.schatapp.desktop.ui.homepage.composition.chat

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import indi.midreamsheep.schatapp.desktop.manager.GlobalManager
import indi.midreamsheep.schatapp.desktop.manager.chat.SChatInfo
import indi.midreamsheep.schatapp.desktop.service.update.UpdateSignal
import indi.midreamsheep.schatapp.desktop.ui.theme.MainTheme
import indi.midreamsheep.schatapp.frame.net.entity.pojo.Message
import java.util.*

@Composable
@Preview
fun ChatWindow(
    modifier: Modifier,
    manager: MutableState<GlobalManager>,
    currentInfo: MutableState<SChatInfo>,
    currentMessages: MutableState<SortedMap<Long, Message>>,
    produceState: State<UpdateSignal>,
) {

    Card(
        modifier.padding(end = 10.dp, bottom = 8.dp),
        shape = RoundedCornerShape(14.dp)
    ) {
        Column {
            toolBar(Modifier.height(60.dp).background(MaterialTheme.colors.secondaryVariant),currentInfo)
            chat(Modifier.background(MaterialTheme.colors.background).weight(1f),currentMessages,produceState)
            input(Modifier.height(60.dp).background(MaterialTheme.colors.background),manager)
        }
    }
}

@Composable
fun toolBar(modifier: Modifier, currentInfo: MutableState<SChatInfo>) {
    Row(modifier.background(MainTheme.secondaryVariant)) {
        Column {
            Text(currentInfo.value.name, fontSize = 24.sp, modifier = Modifier.padding(start = 5.dp, top = 5.dp, bottom = 5.dp))
            Text("chat_info", fontSize = 15.sp, modifier = Modifier.padding(start = 5.dp))
        }
        Spacer(modifier = Modifier.weight(1f))
        Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxHeight()) {
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .size(60.dp)
                    .padding(5.dp)
            ) {
                Icon(
                    Icons.Outlined.Menu,
                    contentDescription = "menu",
                    tint = MaterialTheme.colors.primary
                )
            }
        }
    }
}

@Composable
fun chat(
    modifier: Modifier,
    messages: MutableState<SortedMap<Long, Message>>,
    produceState: State<UpdateSignal>
) {
    val update = produceState.value
    var message by remember{ mutableStateOf(messages.value.values.toList()) }
    message = messages.value.values.toList()
    LazyColumn(modifier.background(MaterialTheme.colors.background)){
        items(message, key = { it.id }) {
            messageCard(it)
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun input(modifier: Modifier, manager: MutableState<GlobalManager>) {
    Row(modifier) {
        var text by rememberSaveable { mutableStateOf("") }
        OutlinedTextField(
            colors = TextFieldDefaults.textFieldColors(
                containerColor = MaterialTheme.colors.secondaryVariant,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
            leadingIcon = {
                Image(
                    painter = painterResource("icon/img.png"),
                    contentDescription = "emoji",
                    modifier = Modifier
                        .size(
                            width = 20.dp,
                            height = 20.dp
                        )
                )
            },
            trailingIcon = {
                Row {
                    Image(
                        painterResource("icon/sticks.png"), contentDescription = "send",
                        modifier = Modifier.padding(end = 8.dp)
                            .size(
                                width = 20.dp,
                                height = 20.dp
                            )
                            .clickable {
                                text = ""
                            },
                    )
                    Image(
                        painterResource("icon/vector.png"), contentDescription = "attach",
                        modifier = Modifier.padding(end = 15.dp)
                            .size(
                                width = 20.dp,
                                height = 20.dp
                            )
                            .clickable {
                                sendMessage(manager,text,manager.value.currentServer.currentInfo.id)
                                text = ""
                            },
                    )
                }
            },
            shape = RoundedCornerShape(100),
            textStyle = TextStyle(
                fontSize = 13.sp,
            ),
            value = text,
            onValueChange = { text = it },
            singleLine = true,
            modifier = Modifier.onPreviewKeyEvent {
                when {
                    (it.key == Key.Enter && it.type == KeyEventType.KeyUp) -> {
                        sendMessage(manager,text,manager.value.currentServer.currentInfo.id)
                        text = ""
                        true
                    }

                    else -> false
                }
            }.height(47.dp).weight(1f).padding(end = 10.dp, start = 10.dp),
        )
    }
}

fun sendMessage(
    manager: MutableState<GlobalManager>,
    message:String,
    messageTo:Long
){

}