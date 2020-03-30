package nettyrpc.server;

import java.util.HashMap;
import java.util.Map;

public class MyRpcAnnotation {
    public static void annotationHandler(Class<ServiceImpl> serviceClass)throws Exception {
        //解析注解目的
        //获取注解value值  实例化对象
        RpcService nclass=serviceClass.getAnnotation(RpcService.class);
        String key=nclass.value();
        map.put(key,serviceClass.newInstance());
    }

    public static Map<String,Object> map=new HashMap<String, Object>();

    public static Map<String,Object> getMap() {
        return map;
    }
}
