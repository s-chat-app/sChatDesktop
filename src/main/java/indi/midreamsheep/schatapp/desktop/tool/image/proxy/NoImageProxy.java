package indi.midreamsheep.schatapp.desktop.tool.image.proxy;

import androidx.compose.ui.graphics.ImageBitmap;
import indi.midreamsheep.schatapp.desktop.tool.image.ImageProxy;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NoImageProxy implements ImageProxy {

    private ImageBitmap imageBitmap;

    @Override
    public ImageBitmap getImage() {
        return this.imageBitmap;
    }
}
