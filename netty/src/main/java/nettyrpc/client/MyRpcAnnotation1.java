package nettyrpc.client;

import io.netty.channel.ChannelHandlerContext;
import nettyrpc.server.Service;

import java.lang.reflect.Field;

public class MyRpcAnnotation1 {

    public static void annotationHandler(Object o, ChannelHandlerContext ctx) throws Exception {
        Field field=o.getClass().getDeclaredField("service");
//        Autowire autowire=field.getAnnotations(Autowire.class);
//        if(autowire!=null){
//            Service service=MyHandler.newMapperProxy(Service.class,ctx);
//            o.getClass().getMethod("setService",Service.class).invoke(o,service);
//        }
    }


}
