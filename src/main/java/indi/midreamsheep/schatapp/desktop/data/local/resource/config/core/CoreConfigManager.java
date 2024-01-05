package indi.midreamsheep.schatapp.desktop.data.local.resource.config.core;

import indi.midreamsheep.schatapp.desktop.data.runtime.constant.GlobalConstants;
import indi.midreamsheep.schatapp.desktop.context.di.mapdi.annotation.MapInjector;
import indi.midreamsheep.schatapp.desktop.data.local.resource.config.AbstractConfigManager;
import live.midreamsheep.frame.sioc.di.annotation.basic.comment.Comment;
import live.midreamsheep.frame.sioc.di.annotation.basic.comment.Injector;

import java.io.File;

import static java.io.File.separator;

@MapInjector("core")
@Comment
public class CoreConfigManager extends AbstractConfigManager {

    @Injector
    private GlobalConstants globalConstants;

    @Override
    protected File getConfigFile() {
        return new File(globalConstants.configPath +"core"+ separator+"core.properties");
    }
}
