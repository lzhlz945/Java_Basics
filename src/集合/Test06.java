package 集合;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Test06 {
    public static void main(String[] args) {
        Set set=new HashSet();
        set.add(123);
        set.add(new Person("zs",34));
        set.add("aa");
        set.add("bb");
        set.add(1234);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
