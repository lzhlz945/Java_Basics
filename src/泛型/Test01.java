package 泛型;

import 集合.Person;

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
}

class User1 extends User<Integer>{

}