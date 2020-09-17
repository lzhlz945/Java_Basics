package 集合;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Test10
{
    public static void main(String[] args){

        try( FileInputStream fis=new FileInputStream("E:\\Java_Basics\\src\\jdbc.properties")) {
            Properties properties=new Properties();

            properties.load(fis);
            String name = properties.getProperty("name");
            System.out.println(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
