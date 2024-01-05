package indi.midreamsheep.schatapp.desktop.local.resource;

import indi.midreamsheep.schatapp.desktop.context.di.mapdi.annotation.MapInjector;
import indi.midreamsheep.schatapp.desktop.local.resource.config.ConfigManager;
import live.midreamsheep.frame.sioc.di.annotation.basic.comment.Comment;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Comment
@MapInjector(Inject = false)
public class LocalResourceManager {

    @MapInjector
    public Map<String, ConfigManager> configManagerMap = new HashMap<>();

    public void loadAllConfig(){
        configManagerMap.values().forEach(configManager -> {
            try {
                configManager.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
