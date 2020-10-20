package io流;

import org.junit.Test;

import java.io.File;

public class TestIo {
    /**
     * file的三种有参构造方法
     */
    @Test
    public void test01(){
        //1.相对路径
        File file1 = new File("hello.txt");

        //2.绝对路径

        File file2 = new File("E:\\io\\file2.txt");

        //3.

        File file3 = new File("E:\\io","io1");
        //4

        File file4 = new File(file3,"file1.txt");
        System.out.println(file1);
        System.out.println(file2);
        System.out.println(file3);
        System.out.println(file4);
        file1.getName();
        file2.getAbsoluteFile();
    }
}
