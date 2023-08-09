package indi.midreamsheep.schatapp.desktop.ui.homepage.composition.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.*
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun ChatList(modifier: Modifier) {
    Column(modifier) {
        var text by rememberSaveable { mutableStateOf("") }
        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("search") },
            singleLine = true,
            leadingIcon = {
                Icon(Icons.Outlined.Search, contentDescription = "Search",
                    modifier = Modifier.clickable { text = "" })
            },
            modifier = Modifier.onPreviewKeyEvent {
                when {
                    (it.key == Key.Enter && it.type == KeyEventType.KeyUp) -> {
                        text = ""
                        true
                    }
                    else -> false
                }
            }.height(50.dp))
        Column(Modifier.verticalScroll(rememberScrollState())){
            for (i in 1..10) {
                ListItem(
                    headlineText = { Text("name$i") },
                    overlineText = { Text("last$i") },
                    leadingContent = {
                        Icon(
                            imageVector = Icons.Filled.Favorite,
                            contentDescription = "Localized description",
                        )
                    },
                    trailingContent = { Text("meta") }
                )
            }
        }
    }
}