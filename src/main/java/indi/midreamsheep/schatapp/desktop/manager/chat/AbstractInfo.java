package indi.midreamsheep.schatapp.desktop.manager.chat;

import indi.midreamsheep.schatapp.frame.net.entity.chat.ChatType;
import indi.midreamsheep.schatapp.frame.net.entity.pojo.Message;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.concurrent.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AbstractInfo {
    /**聊天唯一id*/
    protected long id;
    /**聊天类型*/
    protected ChatType type;
    /**聊天名称*/
    protected String name;

    /**聊天头像,url*/
    protected String headPictureUrl;

    /**最大堆结构存储消息*/
    protected SortedMap<Long,Message> messages = Collections.synchronizedSortedMap(new TreeMap<>());

    public AbstractInfo(long id, ChatType type, String name, String headPictureUrl) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.headPictureUrl = headPictureUrl;
    }


    public List<Message> getMessageList() {
        return messages.values().stream().toList();
    }
}
