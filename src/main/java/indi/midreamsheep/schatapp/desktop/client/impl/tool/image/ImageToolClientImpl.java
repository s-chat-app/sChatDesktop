package indi.midreamsheep.schatapp.desktop.client.impl.tool.image;

import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.res.ImageResources_desktopKt;
import indi.midreamsheep.schatapp.desktop.client.service.tool.image.ImageToolClient;
import indi.midreamsheep.schatapp.desktop.tool.image.ImageManager;
import live.midreamsheep.frame.sioc.di.annotation.basic.comment.Comment;
import live.midreamsheep.frame.sioc.di.annotation.basic.comment.Injector;

@Comment
public class ImageToolClientImpl implements ImageToolClient {

    @Injector
    private ImageManager imageManager;

    @Override
    public ImageBitmap getImage(String url) {
        //执行网络请求图片
        //放入缓存
        //返回图片
        //TODO
        return null;
    }


}
