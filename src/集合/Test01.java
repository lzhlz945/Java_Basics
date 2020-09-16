package 集合;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 使用比较时必须要重写equals()方法
 */
public class Test01 {


    public static void main(String[] args) {

        Collection c1=new ArrayList();
        ((ArrayList) c1).add(123);
        System.out.println(c1.contains(123));
        ((ArrayList) c1).add(new Person("zs",12));
        ((ArrayList) c1).add(new String("tt"));
;
        c1.contains(new String("tt"));
        System.out.println(c1.contains(new Person("zs",22)));
        //Person 类没有写equals方法就是false

    }
}
