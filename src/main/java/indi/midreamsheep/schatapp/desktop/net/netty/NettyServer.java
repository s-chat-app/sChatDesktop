package indi.midreamsheep.schatapp.desktop.net.netty;

import indi.midreamsheep.schatapp.desktop.net.netty.prototcp.MessageDecoder;
import indi.midreamsheep.schatapp.desktop.net.netty.prototcp.MessageEncoder;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public final class NettyServer {

    public ChatSender run(String ip, int port) throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap()
                .group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch){
                        //得到pipeline
                        ChannelPipeline pipeline = ch.pipeline();
                        //加入相关handler
                        pipeline.addLast("decoder", new MessageDecoder());
                        pipeline.addLast("encoder", new MessageEncoder());
                        //加入自定义的handler
                        pipeline.addLast(new NettyServerHandler());
                    }
                });
        return new ChatSender(bootstrap.connect(ip, port).sync().channel());
    }
}
