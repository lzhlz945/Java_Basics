package io流;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

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

    @Test
    public void test03() throws IOException {
        //文件夹和文件的创建
        File file = new File("E:\\io\\file2.txt");
        if(!file.exists()){
            file.createNewFile();
            System.out.println("文件创建成功");
        }else {
            System.out.println("删除文件");
            file.delete();
        }



   }
    @Test
    public void test04() throws IOException {
        //mkdir()不会创建上级没有的目录，mkdirs()会创建上级不存在的目录
        File file = new File("E:\\io\\file1\\file4");
        boolean mkdir1 = file.mkdir();
        if(mkdir1){
            System.out.println("文件1创建成功");
        }else {
            System.out.println("文件1创建失败");
        }
        File file2 = new File("E:\\io\\file2\\file3");
        boolean mkdir2 = file2.mkdirs();
        if(mkdir2){
            System.out.println("文件2创建成功");
        }
    }
}
