package 集合;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class Test07 {
    public static void main(String[] args) {
        TreeSet<Person> set=new TreeSet<Person>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
            if(o1 instanceof Person && o2 instanceof Person){
                Person person1=(Person)o1;
                Person person2=(Person)o2;
                return Integer.compare(person1.getAge(),person2.getAge());
            }else {
                throw new RuntimeException("类型不一致");
            }
            }
        });
//        set.add(2);
//        set.add(33);
//        set.add(44);
//        set.add(22);
        set.add(new Person("zs",22));
        set.add(new Person("ls",33));
        set.add(new Person("ww",44));
        set.add(new Person("zl",11));
        set.add(new Person("cq",12));
        set.add(new Person("cq",13));
        for (Iterator<Person> iterator = set.iterator(); iterator.hasNext(); ) {
            Person next = iterator.next();
            System.out.println(next.getName()+":"+next.getAge());
        }
    }
}
