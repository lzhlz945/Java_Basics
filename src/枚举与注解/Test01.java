package 枚举与注解;

/**
 * 构造器私有化
 * 变量被final修饰
 * 只有get()方法
 */
public class Test01 {
    public static void main(String[] args) {
        Session spring = Session.SPRING;
        System.out.println(spring);
    }
}
class Session{
    private  final String name;
    private  final String  desc;

    private Session(String name,String desc) {
        this.name=name;
        this.desc = desc;
    }
    public static final Session SPRING=new Session("春天","春暖花开");
    public static final Session SUMMER=new Session("春天","春暖花开");
    public static final Session AUTUMN=new Session("春天","春暖花开");
    public static final Session WINTER=new Session("春天","春暖花开");

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Session{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
