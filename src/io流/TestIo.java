package io流;

import org.junit.Test;

import java.io.*;

public class TestIo {
    /**
     * file的三种有参构造方法
     */
    @Test
    public void test01() {
        //1.相对路径
        File file1 = new File("hello.txt");

        //2.绝对路径

        File file2 = new File("E:\\io\\file2.txt");

        //3.

        File file3 = new File("E:\\io", "io1");
        //4

        File file4 = new File(file3, "file1.txt");
        System.out.println(file1);
        System.out.println(file2);
        System.out.println(file3);
        System.out.println(file4);
        file1.getName();
        file2.getAbsoluteFile();
    }

    @Test
    public void test02() {
        //File 的文件路径遍历和重命名
        File file = new File("hello.txt");
        File file2 = new File("E:\\java_Thread_Basics\\src");

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
        File file3 = new File("E:\\Java_Basics\\src\\hello.txt");
        File file4 = new File("E:\\io\\file2.txt");

        boolean b = file3.renameTo(file4);
        System.out.println(b);
    }

    @Test
    public void test03() throws IOException {
        //文件夹和文件的创建
        File file = new File("E:\\io\\file2.txt");
        if (!file.exists()) {
            file.createNewFile();
            System.out.println("文件创建成功");
        } else {
            System.out.println("删除文件");
            file.delete();
        }


    }

    @Test
    public void test04() throws IOException {
        //mkdir()不会创建上级没有的目录，mkdirs()会创建上级不存在的目录
        File file = new File("E:\\io\\file1\\file4");
        boolean mkdir1 = file.mkdir();
        if (mkdir1) {
            System.out.println("文件1创建成功");
        } else {
            System.out.println("文件1创建失败");
        }
        File file2 = new File("E:\\io\\file2\\file3");
        boolean mkdir2 = file2.mkdirs();
        if (mkdir2) {
            System.out.println("文件2创建成功");
        }
    }

    /**
     * 一、流IO：
     * FileReader
     */
    @Test
    public void test05() {
        String fis = "E:\\io\\file2\\hello.txt";
        try (
                FileReader fileReader = new FileReader(fis);
        ) {
            int data;
            while ((data = fileReader.read()) != -1) {

                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test06() {
        String fis = "E:\\io\\file2\\hello.txt";
        try (
                FileReader fileReader = new FileReader(fis)
        ) {
            char[] chars = new char[1028];
            while ((fileReader.read(chars)) != -1) {

                String str = new String(chars, 0, chars.length);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * FileWriter
     */
    @Test
    public void test07() {
        String fis = "E:\\io\\file2\\hello1.txt";
        try (
                FileWriter fileReader = new FileWriter(fis)
        ) {

            fileReader.write("hello");
            fileReader.write("_world");
            fileReader.write("\n");
            fileReader.write("china");
            fileReader.write("+++++");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     /**
      * FileReader、writer读写文件
      *
      */
     @Test
     public void test08() {

           String fis="E:\\io\\file2\\hello.txt";
           String fws="E:\\io\\file2\\hello1.txt";
           try (FileReader fileReader = new FileReader(fis);
                  FileWriter fileWriter = new FileWriter(fws) ){
               System.out.println();
               char[] chars=new char[1];
               int len;
               while ((len=fileReader.read(chars))!=-1){
                   fileWriter.write(chars,0,len);

               }
           } catch (Exception e) {
               e.printStackTrace();
           }

       }
       
    @Test
    public void test09() {

        String fis="E:\\io\\file2\\hello.txt";
        String fws="E:\\io\\file2\\hello1.txt";
        try (FileReader fileReader = new FileReader(fis);
             FileWriter fileWriter = new FileWriter(fws) ){
            System.out.println();
            char[] chars=new char[5];

            while ((fileReader.read(chars))!=-1){
                fileWriter.write(chars);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    /**
     * FileInputStream 、outPutStream
     * 处理纯文本可能出现乱码，一个汉字占3个字节
     */
    @Test
    public void test10() {
        String fis="E:\\io\\file2\\kobe.JPG";
        String fws="E:\\io\\file2\\kobe1.JPG";
        try (FileInputStream fileInputStream=new FileInputStream(fis);
             FileOutputStream fileOutputStream=new FileOutputStream(fws)
        ){
           byte[] bytes=new byte[1028];
           int data;
            while ((data=fileInputStream.read(bytes))!=-1){
                fileOutputStream.write(bytes,0,data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     *  Buffered InputStream Out 图片复制
     *  缓冲流加快读写速度的
     *  只需要关闭外层的流即可
     */
    @Test
    public void test11() {
        String fis="E:\\io\\file2\\kobe.JPG";
        String fws="E:\\io\\file2\\kobe1.JPG";
        try (FileInputStream fileInputStream=new FileInputStream(fis);
             FileOutputStream fileOutputStream=new FileOutputStream(fws);
             BufferedInputStream bis=new BufferedInputStream(fileInputStream);
             BufferedOutputStream bos=new BufferedOutputStream(fileOutputStream)
        ){
            byte[] bytes=new byte[5];
            int data;
            while ((data=bis.read(bytes))!=-1){
                bos.write(bytes,0,data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     *  Buffered Reader Out 文本复制
     *  缓冲流加快读写速度的
     *  只需要关闭外层的流即可
     */
    @Test
    public void test12() {
        String fis="E:\\io\\file2\\hello.txt";
        String fws="E:\\io\\file2\\hello1.txt";
        try (FileReader fileInputStream=new FileReader(fis);
             FileWriter fileOutputStream=new FileWriter(fws);
             BufferedReader bis=new BufferedReader(fileInputStream);
             BufferedWriter bos=new BufferedWriter(fileOutputStream)
        ){
           String data;
            while ((data=bis.readLine()) != null ){
                bos.write(data);
                bos.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    }
