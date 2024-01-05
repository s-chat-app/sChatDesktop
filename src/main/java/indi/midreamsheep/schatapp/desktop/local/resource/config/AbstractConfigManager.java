package indi.midreamsheep.schatapp.desktop.local.resource.config;

import java.io.*;
import java.util.Properties;

public abstract class AbstractConfigManager implements ConfigManager{

    protected Properties properties = new Properties();

    private boolean isLoad = false;

    protected abstract File getConfigFile();

    public String get(String key) {
        return properties.getProperty(key);
    }

    public String get(String key, String defaultValue) {
        return properties.getProperty(key,defaultValue);
    }

    public void set(String key, String value) {
        properties.setProperty(key, value);
    }

    @Override
    public void remove(String key) {
        properties.remove(key);
    }

    @Override
    public void load() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(createConfigFile());
        properties.load(fileInputStream);
        isLoad = true;
    }

    @Override
    public void write() throws IOException {
        properties.store(new FileOutputStream(createConfigFile()), null);
    }

    private File createConfigFile() throws IOException {
        File configFile = getConfigFile();
        if (!configFile.exists()) {
            if(configFile.getParentFile().mkdirs()&&configFile.createNewFile()){
                return configFile;
            }
            throw new FileNotFoundException("配置文件不存在且创建失败,路径为:"+configFile.getAbsolutePath());
        }
        return configFile;
    }

    @Override
    public boolean isLoad() {
        return isLoad;
    }
}
