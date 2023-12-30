package indi.midreamsheep.schatapp.desktop.ui.homepage.chatpage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Message(
    onAuthorClick: ()->Unit,
    msg: String,
    isUserMe: Boolean,
    isLastMsg: Boolean,
){
    Row {
        if (isLastMsg) {
            Image(
                painter = painterResource("/icon/chi_tang.png"),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clickable(onClick = onAuthorClick)
                    .padding(horizontal = 8.dp)
                    .size(42.dp)
                    .clip(CircleShape)
                    .align(Alignment.Top)
            )
        }else{
            Spacer(modifier = Modifier.width(57.dp))
        }
        AuthorAndTextMessage(
            msg = msg,
            isUserMe = isUserMe,
            isLastMsg = isLastMsg,
            modifier = Modifier
                .weight(1f).shadow(
                    -1.dp,
                    spotColor = Color.Gray
                )
        )
    }
}

@Composable
fun AuthorAndTextMessage(
    msg: String,
    isUserMe: Boolean,
    isLastMsg: Boolean,
    modifier: Modifier
) {
    Column(modifier) {
        if (isLastMsg){
            AuthorNameTimestamp(msg)
        }
        ChatItemBubble(msg = msg, isUserMe = isUserMe,)
        Spacer(modifier = Modifier.height(3.dp))
    }
}

@Composable
fun ChatItemBubble(msg: String, isUserMe: Boolean) {
    Surface(
        modifier = Modifier
            .clip(RoundedCornerShape(4.dp,10.dp,10.dp,10.dp))
            .background(Color(70, 174, 247))
        ,
        color = if (isUserMe) MaterialTheme.colors.primary else MaterialTheme.colors.surface,
    ) {
        ClickableMessage(
            text = msg,
            isUserMe = isUserMe
        )

    }
}

@Composable
fun ClickableMessage(text: String, isUserMe: Boolean) {
    ClickableText(
        modifier = Modifier.background(Color(70, 174, 247)).padding(6.dp),
        text = buildAnnotatedString {
            append(text)
        },
        style = TextStyle(
            fontSize = 12.sp,
            color = Color.White
        ),
        onClick = {
            //TODO
        })

}

@Composable
fun AuthorNameTimestamp(msg: String) {
    Row (){
        Text(
            text = "chi tang",
            style = TextStyle(
                fontSize = 12.sp,
                color = Color.Black
            )
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = "20:21 PM",
            style = TextStyle(
                fontSize = 10.sp,
                color = Color.Gray
            ))
    }
}
