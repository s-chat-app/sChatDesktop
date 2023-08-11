package indi.midreamsheep.schatapp.desktop.manager.chat;

import indi.midreamsheep.schatapp.frame.net.entity.chat.ChatType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class AbstractInfo {
    /**聊天唯一id*/
    protected long id;
    /**聊天类型*/
    protected ChatType type;
    /**聊天名称*/
    protected String name;
    /**聊天头像,url*/
    protected String headPictureUrl;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ChatType getType() {
        return type;
    }

    public void setType(ChatType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadPictureUrl() {
        return headPictureUrl;
    }

    public void setHeadPictureUrl(String headPictureUrl) {
        this.headPictureUrl = headPictureUrl;
    }

    public AbstractInfo(long id, ChatType type, String name, String headPictureUrl) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.headPictureUrl = headPictureUrl;
    }

    @Override
    public String toString() {
        return "AbstractInfo{" +
                "id=" + id +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", headPictureUrl='" + headPictureUrl + '\'' +
                '}';
    }
}
