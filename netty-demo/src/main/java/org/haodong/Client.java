package org.haodong;

import io.netty.channel.ChannelHandlerContext;

public class Client {
    private ChannelHandlerContext context;
    private String name;

    public Client(ChannelHandlerContext context, String name) {
        this.context = context;
        this.name = name;
    }

    public void postMessage(String msg){
        context.writeAndFlush(msg+"\n");
    }
}
