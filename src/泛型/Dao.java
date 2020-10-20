package 泛型;

import java.util.*;

public class Dao <T>{
    private Map<String,T> map=new HashMap<>();
    public void add(String id,T entity){
        map.put(id,entity);
    }
    public void update(String id,T entity){
        if(!map.containsKey(id)){
            map.put(id,entity);
        }
    }
    public void remove(String id){
        map.remove(id);
    }
    public List<T> valusList(){
        Collection<T> values = map.values();
        List<T> list=new ArrayList<>();
        for (T value : values) {
            list.add(value);
        }
        return list;
    }

}
