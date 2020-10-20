package 泛型;

import org.junit.Test;

import java.util.List;

public class DaoTest {
    @Test
    public void test01(){
        Dao<Start> dao=new Dao<>();
        dao.add("002",new Start(001,22,"zzs"));
        dao.add("003",new Start(002,23,"zdd"));
        dao.add("004",new Start(003,24,"zcd"));

        dao.update("004",new Start(003,33,"efc"));
        List<Start> starts = dao.valusList();
        starts.forEach(System.out::println);

    }

    public static void main(String[] args) {
        Dao<Start> dao=new Dao<>();
        dao.add("001",new Start(001,22,"zzs"));
        dao.add("002",new Start(002,23,"zdd"));
        dao.add("003",new Start(003,24,"zcd"));
        List<Start> starts = dao.valusList();
        starts.forEach(System.out::println);
    }
}
