package indi.midreamsheep.schatapp.desktop.tool.image;

import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.res.ImageResources_desktopKt;
import indi.midreamsheep.schatapp.desktop.client.service.tool.image.ImageToolClient;
import indi.midreamsheep.schatapp.desktop.tool.id.IdUtil;
import indi.midreamsheep.schatapp.desktop.tool.image.proxy.LazyImageProxy;
import indi.midreamsheep.schatapp.desktop.tool.image.proxy.NoImageProxy;
import live.midreamsheep.frame.sioc.di.annotation.basic.comment.Comment;
import live.midreamsheep.frame.sioc.di.annotation.basic.comment.Injector;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * 图像管理器
 * */
@Comment
public class ImageManager {

    /**
     * 用于存储具体的图像数据
     */
    private final Map<Long, ImageProxy> imageProxyMap = new HashMap<>();

    public long putImage(File file) {
        try {
            return putImage(ImageResources_desktopKt.loadImageBitmap(new FileInputStream(file)));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ImageBitmap getImage(long id) {
        if (imageProxyMap.containsKey(id)) {
            return imageProxyMap.get(id).getImage();
        } else {
            throw new RuntimeException("Image not found");
        }
    }

    public long putImageLazy(File file) {
        return putImage(new LazyImageProxy(file));
    }

    public long putImage(ImageProxy imageProxy) {
        long l = IdUtil.generateId();
        imageProxyMap.put(l, imageProxy);
        return l;
    }

    public long putImage(ImageBitmap bitmap) {
        ImageProxy imageProxy = new NoImageProxy(bitmap);
        long l = IdUtil.generateId();
        imageProxyMap.put(l, imageProxy);
        return l;
    }
}
