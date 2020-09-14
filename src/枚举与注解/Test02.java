package 枚举与注解;

public class Test02 {
    public static void main(String[] args) {
        Session1 spring = Session1.SPRING;
        //没有重写toString方法打印的不是地址值
        System.out.println(spring);
        //Enum是其父类
        System.out.println(spring.getClass().getSuperclass());
    }
}
enum Session1{
      SPRING("春天","春暖花开"),
      SUMMER("夏天","春暖花开"),
      AUTUMN("秋天","春暖花开"),
      WINTER("冬天","春暖花开");
     private  final String name;
     private  final String  desc;
//
    private Session1(String name,String desc) {
        this.name=name;
        this.desc = desc;
    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getDesc() {
//        return desc;
//    }
}