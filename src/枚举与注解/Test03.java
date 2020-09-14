package 枚举与注解;
//实现抽象类
public class Test03 {
    public static void main(String[] args) {

        Session2[] values = Session2.values();
        for (Session2 value : values) {
            System.out.println(value);
            value.show();
        }
    }
}
interface Info{
   void show();
     }
enum Session2 implements Info{
    SPRING("春天","春暖花开"){
        @Override
        public void show() {
            System.out.println("1");
        }
    },
    SUMMER("夏天","春暖花开"){
        @Override
        public void show() {
            System.out.println("2");

        }
    },
    AUTUMN("秋天","春暖花开"){
        @Override
        public void show() {
            System.out.println("3");

        }
    },
    WINTER("冬天","春暖花开"){
        @Override
        public void show() {
            System.out.println("4");

        }
    };
    private  final String name;
    private  final String  desc;
    //
    private Session2(String name,String desc) {
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