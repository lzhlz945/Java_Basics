package string;

public class Test02 {
    public static void main(String[] args) {
        String a1="abc";
        String a2=new String("abc");
        String a3=new String("abc");
        System.out.println(a1==a2);
        System.out.println(a3==a2);

        Student zs = new Student("zs", 20);
        Student zs1 = new Student("zs", 20);
        System.out.println((zs.name).equals(zs1.name));

    }

}
class Student{
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;

    }
}
