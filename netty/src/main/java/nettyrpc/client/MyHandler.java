package nettyrpc.client;


import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;

import java.lang.reflect.*;

public class MyHandler implements InvocationHandler{

    private static ChannelHandlerContext ctx;

    @Override
    public Object invoke(Object proxy,Method method,Object[]args) throws Throwable {

        String objectName="service";
        String methodName=method.getName();
        String param=String.valueOf(args[0]);
        String str=objectName+"_"+methodName+"_"+param;
        byte[] request = str.getBytes("utf-8");
        ByteBuf firstMessage= Unpooled.buffer(request.length);
        firstMessage.writeBytes(request);

        ctx.writeAndFlush(firstMessage);

        return "123";
    }


//    public static<T> T newMapperProxy(Class<T> mapperInterface, ChannelHandlerContext ctx) {
//
//        MyHandler.ctx=ctx;
//        ClassLoader classLoader=mapperInterface.getClassLoader();
//        Clsss<?>[] interfaces =new Clsss[]{mapperInterface};
//        MyHandler proxy=new MyHandler();
//        return (T) Proxy.newProxyInstance(classLoader,interfaces,proxy);
//    }
}
