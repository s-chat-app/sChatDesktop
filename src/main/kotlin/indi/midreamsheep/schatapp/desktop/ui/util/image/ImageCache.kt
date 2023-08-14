package indi.midreamsheep.schatapp.desktop.ui.util.image

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter


val urlImageCache = HashMap<String, ImageBitmap>()
val fileImageCache = HashMap<String,ImageBitmap>()

fun getPainterByUrl(url: String): ImageBitmap? {
    return urlImageCache[url]
}

fun getPainterByFile(file: String): ImageBitmap? {
    return fileImageCache[file]
}

fun addPainterByUrl(url: String, painter: ImageBitmap) {
    urlImageCache[url] = painter
}

fun addPainterByFile(file: String, painter: ImageBitmap) {
    fileImageCache[file] = painter
}