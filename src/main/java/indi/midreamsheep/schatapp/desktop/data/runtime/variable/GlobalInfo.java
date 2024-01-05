package indi.midreamsheep.schatapp.desktop.data.runtime.variable;

import live.midreamsheep.frame.sioc.di.annotation.basic.comment.Comment;
import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Comment
@Data
public class GlobalInfo {
    private AtomicLong selectedServerId = new AtomicLong(0);
    private AtomicLong selectedChannelId = new AtomicLong(0);
    /**
     * 侧边栏的状态
     * 0为默认显示好友列表
     * 其他数值为其他需求的显示
     * */
    private AtomicInteger sideBarSelectionType = new AtomicInteger(0);
    private VariablePool variablePool = new VariablePool();
}