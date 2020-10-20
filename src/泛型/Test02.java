package 泛型;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test02 {
    public static void main(String[] args) {

        List<Object> obj1=new ArrayList<>();
        List<String > obj2=new ArrayList<>();
        obj1.add("a");
        obj1.add("b");
        obj1.add("c");
        obj1.add("d");

        obj2.add("n");
        obj2.add("w");
        obj2.add("s");
        obj2.add("e");
        List<?> objects=new ArrayList<>();
        objects=obj2;
        objects=obj1;
        print1(obj1);
        print1(obj2);
        for (Iterator<?> iterator = objects.iterator(); iterator.hasNext(); ) {
            Object next = iterator.next();
            System.out.print(next+"*");
        }


    }
    public static void print1(List<?> list){

        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            System.out.print(next+"*");
        }
        System.out.println("---------------------");

    }
}

