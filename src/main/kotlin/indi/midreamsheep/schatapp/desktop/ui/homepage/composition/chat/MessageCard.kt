package indi.midreamsheep.schatapp.desktop.ui.homepage.composition.chat

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.drawText
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import indi.midreamsheep.schatapp.desktop.ui.theme.MainTheme

@Composable
fun messageCard(isMe: Boolean = false){
    Row(Modifier.padding(8.dp).height(45.dp).fillMaxWidth()){
        Image(
            painter = painterResource("icon/user_send.png"),
            contentDescription = null,
            modifier = Modifier.padding(end = 8.dp)
                .size(40.dp)

        )
        var isExpanded by remember { mutableStateOf(false) }
        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
            Text(
                text = "chitang",
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2
            )
            Spacer(modifier = Modifier.height(4.dp))
            Surface(
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.height(40.dp),
            ) {
                Text(
                    text = "Hasdasdasdasdasdasiudhasuidhuihsaui usiahdihsaidhashdhsiadsad",
                    modifier = Modifier.padding(all = 4.dp),
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    style = MaterialTheme.typography.body2,
                    fontSize = 14.sp
                )
            }
        }
    }
}