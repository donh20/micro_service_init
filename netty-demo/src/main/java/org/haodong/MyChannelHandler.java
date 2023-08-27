package org.haodong;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Hashtable;
import java.util.Map;

public class MyChannelHandler extends  ChannelInboundHandlerAdapter{
    private static Map<String,Client> clients=new Hashtable<>();
    private String name;

    //当channel被激活的回调（第次连接只发生一次）
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("有客户端的连接 channel id is ："+ctx.channel().id());
        ctx.writeAndFlush("请输入用户和密码(用 : 分开)");
    }

    //当客户端发送数据时的回调处理
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //msg：如果设置了encoder编码器，则msg为String类型
        System.out.print("服务器线程名："+Thread.currentThread().getName()+"收到数据：" + msg);

        String[] lines=msg.toString().trim().split(":");
        System.out.println("lines[0]="+lines[0].length());
        switch (lines[0]){
            case "login":
                String name = LoginServer.login(lines[1], lines[2]);
                if(name!=null){
                    this.name=name;
                    Client client = new Client(ctx, name);
                    clients.put(name,client);
                    client.postMessage("登录成功!");
                }
                else{
                    ctx.writeAndFlush("用户名或密码错!\n");
                }
                break;
            case "health":
                StringBuilder builder=new StringBuilder();
                clients.forEach((na,context)-> {
                    builder.append(na+"\n");
                });
                ctx.writeAndFlush(builder.toString());
                break;
            case "chat":
                Client client=select(lines[1]);
                client.postMessage(this.name+"对你说："+lines[2]);
                break;
            case "bye":
                ctx.disconnect();
                clients.remove(this.name);
        }
        //ctx:处理连接上下文的对象
        if(msg.toString().startsWith(".exit")){
            System.out.println("exit.....");
            ctx.disconnect();
        }
    }
    private Client select(String name){
        return clients.get(name);
    }

}