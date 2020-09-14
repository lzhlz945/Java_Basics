package string;

public class Test06 {
    public static void main(String[] args) {
        StringBuffer s1=new StringBuffer("abc");
        StringBuffer s2=new StringBuffer();
        System.out.println(s1.length());
        System.out.println(s2.length());
        s2.append("a");
    }
}
