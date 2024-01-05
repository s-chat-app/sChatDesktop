package indi.midreamsheep.schatapp.desktop.net;

import live.midreamsheep.frame.sioc.di.annotation.basic.comment.Comment;
import lombok.Data;

import java.util.concurrent.atomic.AtomicLong;

@Comment
@Data
public class GlobalInfo {
    private AtomicLong selectedServerId = new AtomicLong(0);
    private AtomicLong selectedChannelId = new AtomicLong(0);
}