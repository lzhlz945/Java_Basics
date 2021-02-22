package 动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: create by zhl
 * @version: v1.0
 * @description: 动态代理
 * @date:2020/10/26
 */
public interface A {
    void bileaf();
    String like(String someThing);
}
class B implements A{
    @Override
    public void bileaf() {

        System.out.println("学习每一天");
    }

    @Override
    public String like(String someThing) {
        return someThing;
    }
}
class MyHandler1 implements InvocationHandler{

    private Object obj;
    public void bind(Object o1){
        this.obj=o1;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object o=method.invoke(obj,args);
        return o;
    }
}
class MyProxy {
    public static Object proxy(Object obj){

        InvocationHandler myHandler1=new MyHandler1();
        ((MyHandler1) myHandler1).bind(obj);
        Object o = Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), myHandler1);
        return o;
    }


}
class TestProxy01{
    public static void main(String[] args) {
        B b=new B();
        MyProxy proxy=new MyProxy();
        A proxy1 = (A) proxy.proxy(b);
        proxy1.bileaf();
        String like = proxy1.like("飞上天空");
        System.out.println(like);

    }

}