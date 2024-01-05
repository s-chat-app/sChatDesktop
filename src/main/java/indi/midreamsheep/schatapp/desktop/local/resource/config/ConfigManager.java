package indi.midreamsheep.schatapp.desktop.local.resource.config;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 配置文件管理器
 * */
public interface ConfigManager {
    String get(String key);
    String get(String key, String defaultValue);
    void set(String key, String value);
    void remove(String key);
    void load() throws IOException;
    boolean isLoad();
    void write() throws IOException;
}