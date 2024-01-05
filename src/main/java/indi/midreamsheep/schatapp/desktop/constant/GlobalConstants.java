package indi.midreamsheep.schatapp.desktop.constant;

import live.midreamsheep.frame.sioc.di.annotation.basic.comment.Comment;

import static java.io.File.separator;

@Comment
public class GlobalConstants {
    public final String rootPath = System.getProperty("user.dir");
    public final String configPath = rootPath +separator+ "config"+separator;
}
