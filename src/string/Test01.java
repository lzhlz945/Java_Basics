package string;

/**
 * 1.String是存放在方法区的，方法区不会存放两个相同的值
 * String s1="abc"; String s2="abc"; 在栈区中的s1和s2的地址都是指向同一个方法区的“abc” ,
 * s1==s2 （true）
 * 2.实现了Comparable和Serializable序列化
 * 3.字符串常量池不会存储相同的字符串
 * 4.重新赋值需要创建一个新的内存（不可变性）
 * 5.当对现有的进行连接操作是也是需要重新赋值
 * 6.替换也需要重新赋值
 */
public class Test01 {
    public static void main(String[] args) {
        int a;
        String s1="abc";
        String s2="abc";
        System.out.println(s1==s2);
        s1="hello";
        System.out.println(s1==s2);
        String s3="abc";

        s3+="d";
        System.out.println(s3);
        String s4="abc";
        String s5 = s4.replace("a", "k");
        System.out.println(s5);
        System.out.println(s4);



    }
}
