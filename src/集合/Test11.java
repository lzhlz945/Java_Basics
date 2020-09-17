package 集合;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test11 {
    public static void main(String[] args) {
        List list=new ArrayList();
        list.add(1);
        list.add(22);
        list.add(2);
        list.add(4);
        list.add(3);
        Collections.shuffle(list);
        for (Object o : list) {
            System.out.println(o);
        }
        System.out.println("********************");
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));

        }
    }

}
