package indi.midreamsheep.schatapp.desktop.entity.account.chat.channel;

public interface ChatChannel {

        /**
        * 获取通道id
        */
        long getChannelId();

        /**
        * 获取通道名称
        * */
        String getName();
        /**
        * 获取最后一条消息
        * */
        String getLastMessage();
        /**
        * 获取通道最后一条消息时间
        * */
        long getLastMessageTime();
        /**
        * 获取通道最后一条消息发送者的显示图标id
        * */
        long getAvatar();
        /**
        * 获取未读消息个数
        * */
        int getUnreadMessageCount();
}
