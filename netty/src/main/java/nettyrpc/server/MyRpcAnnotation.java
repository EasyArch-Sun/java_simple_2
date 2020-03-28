package nettyrpc.server;

import java.util.HashMap;
import java.util.Map;

public class MyRpcAnnotation {
    public static void annotationHandler(Class<ServiceImpl> serviceClass) {
//        RpcServer nclass=serviceClass.getAnnotations(RpcServer.class);
//        String key=nclass.value();
//        map.put(key,serviceClass.newInstance());
    }

    public static Map<String,Object> map=new HashMap<String, Object>();

    public static Map<String,Object> getMap() {
        return map;
    }
}
