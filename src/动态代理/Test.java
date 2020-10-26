package 动态代理;

/**
 * @author: create by zhl
 * @version: v1.0
 * @description: 动态代理
 * @date:2020/10/26
 */
public class Test {

    /**
     * 静态代理：代理类和被代理类在编译期间就被确定下来了
     */
    public static void main(String[] args) {
        Factory factory=new NikeFactory();
        CloseFatory closeFatory = new CloseFatory(factory);
        closeFatory.closh();

    }



}
interface Factory{
    void closh();
}
//代理类
class CloseFatory implements Factory{

    Factory factory;

    public CloseFatory(Factory factory) {
        this.factory = factory;
    }

    @Override
    public void closh() {
        System.out.println("代理类之前在处理事情-----");
        factory.closh();
        System.out.println("代理类处理收尾工作");
    }
}
//被代理类
class NikeFactory implements Factory{

    @Override
    public void closh() {
        System.out.println("Nike自己提供技术和材料++++++++");
    }
}
