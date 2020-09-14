package string;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Test08Date {
    public static void main(String[] args) {
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date=new Date();
        System.out.println(date);
        String format1 = format.format(date);
        System.out.println(format1);
        Calendar instance = Calendar.getInstance();
        System.out.println(instance.getClass());
        Calendar c=new GregorianCalendar();
        int dayOfMonth = c.get(Calendar.DAY_OF_MONTH);
        System.out.println(dayOfMonth);
        int value = 22;
        c.set(Calendar.DAY_OF_MONTH, value);
        dayOfMonth = c.get(Calendar.DAY_OF_MONTH);
        System.out.println(dayOfMonth);
        c.add(Calendar.DAY_OF_MONTH,3);
        dayOfMonth = c.get(Calendar.DAY_OF_MONTH);
        System.out.println(dayOfMonth);
        c.add(Calendar.DAY_OF_MONTH,-3);//Calendar没有减操作，+一个负数就是减操作
        dayOfMonth = c.get(Calendar.DAY_OF_MONTH);
        System.out.println(dayOfMonth);

        //Date与Calendar转换
        Date time = c.getTime();
        System.out.println(time);
        Date date11;
        date11 = new Date();
        c.setTime(date11);
        dayOfMonth = c.get(Calendar.DAY_OF_MONTH);
        System.out.println(dayOfMonth);



    }
}
