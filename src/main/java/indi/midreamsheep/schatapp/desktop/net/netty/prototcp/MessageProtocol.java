package indi.midreamsheep.schatapp.desktop.net.netty.prototcp;

import lombok.Data;

/**
 * 解决netty半包粘包问题的自定义协议
 * */
@Data
public class MessageProtocol {
    /**消息长度*/
    private int len;
    /**消息内容*/
    private byte[] content;
}
