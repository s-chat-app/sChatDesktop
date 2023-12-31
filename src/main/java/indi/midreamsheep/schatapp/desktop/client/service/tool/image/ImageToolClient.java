package indi.midreamsheep.schatapp.desktop.client.service.tool.image;

import androidx.compose.ui.graphics.ImageBitmap;

import java.io.File;

public interface ImageToolClient {
    ImageBitmap getImage(String url);
}
