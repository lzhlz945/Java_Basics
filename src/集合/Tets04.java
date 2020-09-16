package 集合;

import java.util.ArrayList;
import java.util.List;

/**
 * list.add(123) elementData[0]=new Integer(123);
 * jdk 1.7中
 * 如果此次的添加导致底层elementDate数组容量不够则扩容
 * 默认情况下，扩容为原来的容量的1.5倍，同时需要将原有数组中的数据复制到新的数组
 *
 * jdk 1.8中
 *
 * object[] elementData初始化为{} 并没有在构造器中创建默认为10
 * 使用add();时才创建长度为10 的数组
 */
public class Tets04 {
    public static void main(String[] args) {
        List list=new ArrayList();
        list.add(123);
    }
}
