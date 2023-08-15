package indi.midreamsheep.schatapp.desktop.manager.chat;

import java.util.List;

public interface AbstractManager<T extends SChatInfo> {
    List<T> getChatList();
    T getChat(long id);
    void addChat(T info);
}
