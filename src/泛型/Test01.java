package 泛型;

import 集合.Person;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 自定义泛型类
 * 让泛型作为参数传递
 */
public class Test01 {
    public static void main(String[] args) {
        User user=new User();
        user.settOrder(123);
        User<String> user1=new User<String>();
        System.out.println(user);
        User1 user11=new User1();
        user11.settOrder(123);
        Integer[] integer=new Integer[]{1,2,3};
        user.copy(integer);

    }
}
class User<T>{
    String name;
    int age;
    T tOrder;

    public User() {
    }

    public User(String name, int age, T tOrder) {
        this.name = name;
        this.age = age;
        this.tOrder = tOrder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public T gettOrder() {
        return tOrder;
    }

    public void settOrder(T tOrder) {
        this.tOrder = tOrder;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", tOrder=" + tOrder +
                '}';
    }
    //泛型方法：有泛型结构的才是泛型方法，与接口和类是否泛型无关
    public <E> List<E> copy(E[] arry){
      List<E> list=new ArrayList<E>();
        for (E e : arry) {
            list.add(e);
        }
        for (Iterator<E> iterator = list.iterator(); iterator.hasNext(); ) {
            E next = iterator.next();
            System.out.println(next);

        }
        return list;
    }


}

class User1 extends User<Integer>{

}