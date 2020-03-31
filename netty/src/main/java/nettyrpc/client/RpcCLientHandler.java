package nettyrpc.client;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;


public class RpcCLientHandler extends SimpleChannelInboundHandler<ByteBuf> {

    //客户端连接服务器后被调用
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        System.out.println("client 写数据");

        Controller c=new Controller();
        MyRpcAnnotation1.annotationHandler(c,ctx);
        c.test();
    }

    //服务器接收到数据后调用
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        System.out.println("client 读取数据");

        ByteBuf buffer=(ByteBuf)msg;
        byte[] request =new byte[buffer.readableBytes()];
        //buffer.readByte(request);
        String body=new String(request,"UTF-8");
        System.out.println(body);
    }


    //发生异常被调用
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("Client exceptionCaught");
        ctx.close();
    }
}
