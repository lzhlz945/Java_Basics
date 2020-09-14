package 集合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * 数组和list互转
 */
public class Test02 {


    public static void main(String[] args) {

        Collection c1=new ArrayList();
        ((ArrayList) c1).add(123);
        System.out.println(c1.contains(123));
        ((ArrayList) c1).add(new Persion("zs"));
        ((ArrayList) c1).add(new String("tt"));

        //1、hashCode返回
        System.out.println(c1.hashCode());

        //2、集合转数组
        Object[] objects = c1.toArray();
        for (Object object : objects) {
            System.out.println(object);
        }
        //数组转集合
        Collection c2= Arrays.asList(new String[]{"a","b","c"});
        System.out.println(c2.size());
        List<int[]> ints = Arrays.asList(new int[]{1, 2});
        System.out.println(ints.size());
        List ints1 =  Arrays.asList(new Integer[]{1, 2});
        System.out.println(ints1.size());

    }
}
