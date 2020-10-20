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

    @Test
    public void test02(){
        //File 的文件路径遍历和重命名
        File file=new File("hello.txt");
        File file2=new File("E:\\java_Thread_Basics\\src");

        String[] list = file2.list();
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("************");
        File[] files = file2.listFiles();
        for (File file1 : files) {
            System.out.println(file1);
        }
        //重命名  file3必须存在 且 file4不存在
        File file3=new File("E:\\Java_Basics\\src\\hello.txt");
        File file4=new File("E:\\io\\file2.txt");

        boolean b = file3.renameTo(file4);
        System.out.println(b);
    }
}
