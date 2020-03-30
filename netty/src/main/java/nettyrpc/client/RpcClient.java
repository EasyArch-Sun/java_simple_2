package nettyrpc.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

public class RpcClient {

    public static String host="172.0.0.1";
    public static int port=6666;

    public static void main(String[] args) throws InterruptedException {
        RpcClient.start();
    }

    private static void start() throws InterruptedException {

        EventLoopGroup nioEventLoopGroup =null;

        try {
            //boootstrap对象引导启动客户端
            Bootstrap bootstrap = new Bootstrap();

            //线程池
            nioEventLoopGroup = new NioEventLoopGroup();

            //InetSocketAddress指定连接的服务器地址
            //客户端连接成功后执行ChannelHandler
            bootstrap.group(nioEventLoopGroup).
                    channel(NioSocketChannel.class).
                    remoteAddress(new InetSocketAddress(host, port)).
                    handler(new ChannelInitializer<SocketChannel>() {

                        protected void initChannel(SocketChannel channel) throws Exception {
                            channel.pipeline().addLast(new RpcCLientHandler());
                        }
                    });

            //bootstrap.connect()连接服务器
            ChannelFuture channelFuture = bootstrap.connect().sync();
            channelFuture.channel().closeFuture().sync();

        }finally {
            //释放资源
            nioEventLoopGroup.shutdownGracefully().sync();
        }


    }
}
