package indi.midreamsheep.schatapp.desktop.manager.server;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**服务器元数据*/
@NoArgsConstructor
@AllArgsConstructor
public class ServerMeta {
    /**ip地址*/
    private String ip;

    /**端口号*/
    /*聊天通道端口*/
    private int channelPort;
    /*其他信息请求端口*/
    private int controlPort;

    /**本地服务器id，用于标识服务器*/
    private long id;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getChannelPort() {
        return channelPort;
    }

    public void setChannelPort(int channelPort) {
        this.channelPort = channelPort;
    }

    public int getControlPort() {
        return controlPort;
    }

    public void setControlPort(int controlPort) {
        this.controlPort = controlPort;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
