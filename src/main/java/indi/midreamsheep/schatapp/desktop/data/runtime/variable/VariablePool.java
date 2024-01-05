package indi.midreamsheep.schatapp.desktop.data.runtime.variable;

import live.midreamsheep.frame.sioc.di.annotation.basic.comment.Comment;

import java.util.Properties;

@Comment
public class VariablePool {
    Properties properties = new Properties();
    public void setProperty(String key, String value){
        properties.setProperty(key, value);
    }
    public String getProperty(String key){
        return properties.getProperty(key);
    }
    public String getProperty(String key, String defaultValue){
        return properties.getProperty(key, defaultValue);
    }

    public void removeProperty(String key){
        properties.remove(key);
    }
}
