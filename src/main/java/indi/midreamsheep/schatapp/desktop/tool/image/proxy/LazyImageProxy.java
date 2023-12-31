package indi.midreamsheep.schatapp.desktop.tool.image.proxy;

import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.res.ImageResources_desktopKt;
import indi.midreamsheep.schatapp.desktop.tool.image.ImageProxy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class LazyImageProxy implements ImageProxy {

    private File file;

    private ImageBitmap imageBitmap;

    public LazyImageProxy(File file) {
        this.file = file;
    }

    @Override
    public ImageBitmap getImage() {
        if (this.imageBitmap == null) {
            try {
                this.imageBitmap = ImageResources_desktopKt.loadImageBitmap(new FileInputStream(file));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return imageBitmap;
    }
}
