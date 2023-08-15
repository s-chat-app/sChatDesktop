package indi.midreamsheep.schatapp.desktop.manager.chat.individual;

import indi.midreamsheep.schatapp.desktop.manager.chat.AbstractManager;
import indi.midreamsheep.schatapp.desktop.manager.chat.SChatInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndividualManager implements AbstractManager<SChatInfo> {

    Map<Long,SChatInfo> chatMap = new HashMap<>();

    @Override
    public List<SChatInfo> getChatList() {
        //将map转换为list
        return new ArrayList<>(chatMap.values());
    }

    @Override
    public SChatInfo getChat(long id) {
        return chatMap.get(id);
    }

    @Override
    public void addChat(SChatInfo info) {
        chatMap.put(info.getId(),info);
    }
}
