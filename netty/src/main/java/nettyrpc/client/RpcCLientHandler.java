package nettyrpc.client;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.lang.reflect.Method;

public class RpcCLientHandler extends SimpleChannelInboundHandler<ByteBuf> {

    //服务器接收到数据后调用
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
        System.out.println("client 读取数据");

        //ByteBuf buffer=(ByteBuf)msg;
        byte[] request =new byte[byteBuf.readableBytes()];
        //byteBuf.readByte(request);
        String body=new String(request,"UTF-8");
        System.out.println(body);
    }

    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        System.out.println("client 写数据");

        Controller c=new Controller();
        MyRpcAnnotation1.annotationHandler(c,ctx);
        c.test();

    }

    //发生异常被调用
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("Client exceptionCaught");
        ctx.close();
    }
}
