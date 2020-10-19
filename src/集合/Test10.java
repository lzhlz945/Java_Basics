package 集合;

import java.util.Enumeration;
import java.util.ResourceBundle;

public class Test10
{
    public static void main(String[] args) {

        ResourceBundle resourceBundle=ResourceBundle.getBundle("jdbc.properties");
        Enumeration<String> keys = resourceBundle.getKeys();
       while (keys.hasMoreElements()){
           String s = keys.nextElement();
           String string = resourceBundle.getString(s);
           System.out.println(s+":"+string);
       }
     /* try (FileInputStream fis=new FileInputStream("E:\\Java_Basics\\src\\jdbc.properties")){
          Properties properties=new Properties();
          properties.load(fis);
          String name = properties.getProperty("name");
          System.out.println(name);
      }catch (Exception e){

      }*/
    }

}
