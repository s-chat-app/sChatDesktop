package indi.midreamsheep.schatapp.desktop.manager.chat.individual;

import indi.midreamsheep.schatapp.desktop.manager.chat.AbstractInfo;
import indi.midreamsheep.schatapp.frame.net.entity.chat.ChatType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
public class FriendUserInfo extends AbstractInfo {
    public FriendUserInfo(long id, ChatType type, String name, String headPictureUrl) {
        super(id, type, name, headPictureUrl);
    }
}
