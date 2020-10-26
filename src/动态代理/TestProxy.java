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
interface Human{
    void belif();
    String eat(String eat);
}

class SuperMan implements Human{

    @Override
    public void belif() {
        System.out.println("如果超人会飞，我想在空中停一停些！！！！！！");
    }

    @Override
    public String eat(String eat) {

        return "超人喜欢吃："+eat;
    }
}

class MyHandler implements InvocationHandler{

    private Object obj;

    public void bind(Object obj){
        this.obj=obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object obj = method.invoke(this.obj, args);
        return obj;
    }
}

class ProxyFactory{
    public static Object factory(Object obj){
        MyHandler handler=new MyHandler();
        handler.bind(obj);
        Object o = Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
        return o;


    }

}

public class TestProxy {


    public static void main(String[] args) {

    SuperMan superMan=new SuperMan();
        ProxyFactory factory=new ProxyFactory();
        Human factory1 = (Human) factory.factory(superMan);
        factory1.belif();
        String eat = factory1.eat("重庆火锅");
        System.out.println(eat);
    }
}
