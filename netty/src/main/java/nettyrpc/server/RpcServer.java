package nettyrpc.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class RpcServer {
    private static final int port=6666;

    public static void main(String[] args) throws Exception {
        MyRpcAnnotation.annotationHandler(ServiceImpl.class);

        EventLoopGroup bossgroup=new NioEventLoopGroup();
        EventLoopGroup workerroup=new NioEventLoopGroup();

        try{
            ServerBootstrap serverBootstrap=new ServerBootstrap();

//            serverBootstrap.group(bossgroup,workerroup).channel(NioServerSocketChannel.class).
//                    childHandler(new ChannelInitializer<SocketChannel>() {
//
//                        protected void initChannel(SocketChannel channel) throws Exception {
//                            channel.pipeline().addLast(new RpcServerHandler());
//                        }
//                    });

            serverBootstrap.group(bossgroup,workerroup);
            serverBootstrap.channel(NioServerSocketChannel.class);
            serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {

                protected void initChannel(SocketChannel channel) throws Exception {
                    channel.pipeline().addLast(new RpcServerHandler());
                }
            });

            ChannelFuture channelFuture=serverBootstrap.bind(port).sync();
            channelFuture.channel().closeFuture().sync();


        }finally {

            bossgroup.shutdownGracefully();
            workerroup.shutdownGracefully();

        }

    }



}
