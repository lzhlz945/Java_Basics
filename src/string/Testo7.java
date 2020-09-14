package string;

import java.util.Date;

/**
 * java.util.date是 * java.util.date的父类
 * 之间转换
 * date转换成sql.Date
 *   java.sql.Date date1=new java.sql.Date(1222222233L);
 *         Date date2=(Date)date1;
 * sql.Date转换成Date
 *  Date date=new Date();
 *         java.sql.Date d= new java.sql.Date(date.getTime());
 *         new java.sql.Date() 构造器的参数是毫秒值
 *         只需要date.getTime();就能转换
 */
public class Testo7 {
    public static void main(String[] args) {
        Date date=new Date();
        System.out.println(date);

        java.sql.Date d= new java.sql.Date(date.getTime());
        java.sql.Date date1=new java.sql.Date(1222222233L);

    }
}
