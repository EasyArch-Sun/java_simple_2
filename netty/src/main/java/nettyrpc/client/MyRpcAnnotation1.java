package nettyrpc.client;

import io.netty.channel.ChannelHandlerContext;
import nettyrpc.server.Service;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MyRpcAnnotation1 {

    public static void annotationHandler(Object o, ChannelHandlerContext ctx) throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Field field=o.getClass().getDeclaredField("service");
//        Autowire autowire=field.getAnnotations(Autowire.class);
//        if(autowire!=null){
//            Service service=Hadler.newMapperProxy(Service.class,ctx);
//            o.getClass().getMethod("setService",Service.class).invoke(o,ctx);
//        }
    }

    public static void annotationHandler(Controller c) {
    }
}
