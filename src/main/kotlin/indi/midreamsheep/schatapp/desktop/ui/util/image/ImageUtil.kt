package indi.midreamsheep.schatapp.desktop.ui.util.image

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import indi.midreamsheep.schatapp.desktop.context.SChatApplicationContext
import indi.midreamsheep.schatapp.desktop.tool.image.ImageManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope

@Composable
fun AsyncImage(
    id:Long,
    contentDescription: String,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Fit,
) {
    val image: ImageBitmap? by produceState<ImageBitmap?>(null) {
        value = withContext(Dispatchers.IO) {
           SChatApplicationContext.getApplicationContext().getBean(ImageManager::class.java).getImage(id)
        }
    }

    if (image != null) {
        //通过ImageBitmap加载图片
        Image(
            bitmap = image!!,
            contentDescription = contentDescription,
            contentScale = contentScale,
            modifier = modifier
        )
    }else{
        Image(
            painter = painterResource("icon/image_loading.xml"),
            contentDescription = contentDescription,
            contentScale = contentScale,
            modifier = modifier
        )
    }
}