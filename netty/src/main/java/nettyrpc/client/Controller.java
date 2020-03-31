package nettyrpc.client;

import nettyrpc.client.Service;

public class Controller {

    @Autowire
    private Service service;

    public  void setService(Service service){
        this.service=service;
    }

    public void test(){
        String s=service.s("successful netty rpc");
        System.out.println(s);
    }


//    public static void main(String[] args) {
//        Controller c=new Controller();
//        MyRpcAnnotation1.annotationHandler(c);
//        c.test();
//
//
//    }
}
