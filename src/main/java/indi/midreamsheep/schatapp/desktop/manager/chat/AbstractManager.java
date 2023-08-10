package indi.midreamsheep.schatapp.desktop.manager.chat;

import java.util.List;
import java.util.Map;

public interface AbstractManager<T extends AbstractInfo> {
    List<T> getChatList();
    T getChat(long id);
    void addChat(T info);
}
