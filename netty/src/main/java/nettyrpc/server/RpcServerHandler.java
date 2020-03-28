package nettyrpc.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;


public class RpcServerHandler extends ChannelInboundHandlerAdapter {

    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        System.out.println("server读取数据...");

        //读取数据
        ByteBuf buffer=(ByteBuf)msg;
        byte[] request=new byte[buffer.readableBytes()];
        buffer.readBytes(request);
        String body=new String(request,"UTF-8");
        String[] strs=body.split("_");
        String objectName=strs[0];
        String methodName=strs[1];

        //解析参数类型及值
        String param=strs[2];
        String result=execute(objectName,methodName,param);
        System.out.println(result+"12345");
        
        //返回客户端消息
        byte[] response=result.getBytes("UTF-8");
        ByteBuf firstMassage= Unpooled.buffer(request.length);
        //firstMassage.writeByte(response);
        ctx.writeAndFlush(firstMassage);
    }

    private String execute(String objectName, String methodName, String param) {
        Object o=MyRpcAnnotation.getMap().get(objectName);
        Class serviceClass=o.getClass();
        String result=null;


        try {
            Method method = serviceClass.getMethod(methodName,String.class);
            result=(String)method.invoke(o,param);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return  result;
    }

    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        System.out.println("RamoteAddress:"+ctx.channel().remoteAddress()+
                "active!");
        ctx.writeAndFlush("Welcome to"+ InetAddress.getLocalHost().getHostName()+
                "service!\n");
        super.channelActive(ctx);
    }

}
