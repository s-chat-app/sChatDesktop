package indi.midreamsheep.schatapp.desktop.schatdesktop.until.ui.style;

import javafx.scene.Node;

import java.util.HashMap;
import java.util.Map;

public class SChatStyleManagement<T extends Node> {
    public T node;
    private final Map<String,String> styleMap = new HashMap<>();

    public SChatStyleManagement(T node){
        this.node = node;
        //初始化样式
        String style = node.getStyle();
        String[] styles = style.split(";");
        for (String s : styles) {
            String[] keyValue = s.split(":");
            if (keyValue.length == 2){
                styleMap.put(keyValue[0],keyValue[1]);
            }
        }
    }
    public void addStyle(String key,String value){
        styleMap.put(key,value);
        updateStyle();
    }
    public void addStyle(String style){
        String[] styles = style.split(";");
        for (String s : styles) {
            String[] keyValue = s.split(":");
            if (keyValue.length == 2){
                styleMap.put(keyValue[0],keyValue[1]);
            }
        }
        updateStyle();
    }
    public void removeStyle(String key){
        styleMap.remove(key);
        updateStyle();
    }
    public void updateStyle(){
        StringBuilder style = new StringBuilder();
        for (Map.Entry<String, String> entry : styleMap.entrySet()) {
            style.append(entry.getKey()).append(":").append(entry.getValue()).append(";");
        }
        node.setStyle(style.toString());
    }
}
