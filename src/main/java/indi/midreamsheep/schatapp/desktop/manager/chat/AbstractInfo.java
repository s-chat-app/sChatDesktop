package indi.midreamsheep.schatapp.desktop.manager.chat;

import indi.midreamsheep.schatapp.frame.net.entity.chat.ChatType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
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
}
