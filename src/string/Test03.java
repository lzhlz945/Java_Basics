package string;

/**
 * 字面量 都是放在字符串常量池中只能有一个s==s3 true
 * s1+"" 想当于new
 *
 * 如果调用intern() 返回值就在常量池中
 */
public class Test03 {
    public static void main(String[] args) {
        String s="helloworld";
        String s1="hello";
        String s2="world";
        String s4=s1+"world";
        String s5="hello"+s2;
        String s6=s1+s2;

        String s7 = s4.intern();
        String s3="hello"+"world";
        System.out.println(s==s3);
        System.out.println(s==s4);
        System.out.println(s==s5);
        System.out.println(s==s7);

    }
}
