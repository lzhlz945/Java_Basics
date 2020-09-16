package 集合;

import java.util.Objects;

public class Person implements Comparable{
    private String name;
    private Integer age;

    public Person(){}
    public Person(String name,Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public Integer getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person persion = (Person) o;
        return Objects.equals(name, persion.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
//        if(o instanceof Person){
//            Person person=(Person)o;
//            return this.name.compareTo(person.name);
//        }else {
//            throw new RuntimeException("输入的类型不匹配");
//        }
        if(o instanceof Person){
            Person person=(Person)o;
            int compare=-this.name.compareTo(person.name);
            if(compare != 0){
                return compare;
            }else {
                return Integer.compare(this.age,person.age);
            }
        }else {
            throw new RuntimeException("输入的类型不匹配");

        }

    }
}
