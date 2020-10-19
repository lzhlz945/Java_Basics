package 集合;

import java.util.Enumeration;
import java.util.ResourceBundle;

public class Test09 {
    public static void main(String[] args) {
        ResourceBundle resourceBundle=ResourceBundle.getBundle("集合/tets01");
        Enumeration<String> keys = resourceBundle.getKeys();
        while (keys.hasMoreElements()){
            String s = keys.nextElement();
            String value = resourceBundle.getString(s);
            System.out.print(s+":");
            System.out.println(value);
        }
    }
}
