package indi.midreamsheep.schatapp.desktop.ui.homepage.composition.chat

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun messageCard(isMe: Boolean = false){
    Row{
        if (isMe) {
            Spacer(Modifier.weight(1f))
        }
        Icon(Icons.Outlined.Face, contentDescription = "face", Modifier.padding(end = 10.dp))
        Text("message_name",Modifier.padding(end = 10.dp))

        Text("message_content")
    }
}