package me.ibore.im;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created by ibore on 2017/7/12.
 */
public class SubReqServer {
    public void run(int nPort) throws Exception {

        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try{
            ServerBootstrap b = new ServerBootstrap(); // (2)
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class) // (3)
                    .childHandler(new SimpleChatServerInitializer())  //(4)
                    .option(ChannelOption.SO_BACKLOG, 128)          // (5)
                    .childOption(ChannelOption.SO_KEEPALIVE, true); // (6)

            System.out.println("服务器已启动，等待客户端连接");

            // 绑定端口，开始接收进来的连接
            ChannelFuture f = b.bind(nPort).sync(); // (7)

            // 等待服务器  socket 关闭 。
            // 在这个例子中，这不会发生，但你可以优雅地关闭你的服务器。
            f.channel().closeFuture().sync();
        }finally {
            System.out.println("---------------Shut down");
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }


    public static void main(String[] args){
        int nPort = 9999;
        nPort = Integer.valueOf(nPort);
        System.out.println("---------------Main start");
        try {
            new SubReqServer().run(nPort);
        } catch (Exception e) {
            System.out.println("---------------Main Error");
            e.printStackTrace();
        }
    }
}
