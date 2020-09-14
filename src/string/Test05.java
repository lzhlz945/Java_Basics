package string;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * String与其他类型转换
 * 转换成其他 其他的包装.paseXXX()
 * 其他转换成String.valueOf()
 */
public class Test05 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s="123";
        int i = Integer.parseInt(s);
        System.out.println(i+"---------");
        System.out.println(i);

        String s3="hello";
        char[] chars = s3.toCharArray();
        for (char aChar : chars) {
            System.out.println(aChar);
        }
        //char[] 转换成String 用String的java.lang 包下的构造器区转换
        String s1 = new String(chars);
        //转换成bytes
        String s4="abcde123你好";
        byte[] bytes = s4.getBytes();
        for (byte b : bytes) {
            System.out.print(b+"、");
        }
        String s2 = new String(bytes);
        System.out.println(s2);
        byte[] gbks = s2.getBytes("gbk");
        System.out.println(Arrays.toString(gbks));
    }

}
