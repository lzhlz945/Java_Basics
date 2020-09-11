package string;

/**
 * s1.indexOf()第一次出现的索引值 没有返回-1
 * lastIndexOf()
 */
public class Test04 {
    public static void main(String[] args) {
        String s1="2003-09-09-TM";
        String s2 = s1.substring(0, s1.lastIndexOf("-"));
        System.out.println(s2);
        String[] split = s2.split("[-]");
        for (String s : split) {
            System.out.print(s);
        }


    }
}
