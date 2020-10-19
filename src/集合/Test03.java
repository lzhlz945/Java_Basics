package 集合;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Test03 {
    public static void main(String[] args) {
        Collection c1=new ArrayList();
        ((ArrayList) c1).add(123);
        ((ArrayList) c1).add(new Person("zs",23));
        ((ArrayList) c1).add(new String("tt"));
        ((ArrayList) c1).add(new String("tt"));
        ((ArrayList) c1).add(new String("tt"));
        Iterator iterator = c1.iterator();
//        System.out.println(iterator.hasNext());
//        System.out.println(iterator.hasNext());
//        System.out.println(iterator.hasNext());
        while (iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(next);
            if(next.equals("tt")){
                iterator.remove();
            }
        }
        System.out.println("******************************");
        for (Iterator iterator1 = c1.iterator(); iterator1.hasNext(); ) {
            Object next = iterator1.next();
            System.out.println(next);
        }
        System.out.println(c1.size());
        System.out.println("*****************************");
        for (Iterator iterator1 = c1.iterator(); iterator1.hasNext(); ) {
            Object next = iterator1.next();
            System.out.println(next);
        }

    }
}
