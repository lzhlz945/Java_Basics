package 反射;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author: create by zhl
 * @version: v1.0
 * @description: 反射
 * @date:2020/10/22
 */
public class FanTest {
    /**
     * 反射：
     * 反射机智允许程序在执行期间借助于Reflection API 取得任何类的内部信息
     * ，并能操作任意对象的内部属性及方法
     * 实例化对象--getClass()方法--得到完整包类的名称--操作类的各个属性
     */
    @Test
    public void test01() throws Exception {

        //实例化类，利用构造器
        Class<Person1> person1Class = Person1.class;
        Constructor<Person1> person = person1Class.getConstructor(String.class, Integer.class);
        Object o = person.newInstance("zs", 12);
        System.out.println(o.toString());

        //设置值
        ((Person1) o).setAge(1);

        System.out.println(o.toString());

        //获取方法
        Method method = person1Class.getMethod("show");
        method.invoke(o);


    }

    @Test
    public void test02() throws Exception {
        Class<Person1> p = Person1.class;
        Constructor<Person1> c = p.getDeclaredConstructor(String.class);
        c.setAccessible(true);
        Person1 person1 = c.newInstance("hah");
        System.out.println(person1.toString());

        Field f = p.getDeclaredField("name");
        f.setAccessible(true);
        f.set(person1, "li");
        System.out.println(person1.toString());

        Method showP = p.getDeclaredMethod("showP", String.class);
        showP.setAccessible(true);
        String www = (String) showP.invoke(person1, "zg");//拿到返回值
        System.out.println(www);
    }
    /**
     * 1、类的加载过程：
     * 程序经过java.exe命令对某个字节码文件解释允许。
     * 相当于某个字节码文件加载到内存中，此过程被称为类的加载。
     * 加载到内存中的类，我们就称为运行时类，此运行时类，
     * 就作为一个class实例。
     *
     *
     */


}

class Person1 {
    private String name;
    Integer age;


    public Person1() {

    }

    private Person1(String name) {
        this.name = name;
    }


    public Person1(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void show() {
        System.out.println("wo");
    }

    private String showP(String name) {
        System.out.println(123);
        return "我的名字是： " + name;
    }
}
