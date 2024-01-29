import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache146 {
    static LinkedHashMap<Integer,Integer> cache;
    static int capacity = 2;
    public static void main(String[] args) {
        LRUCacheCapacity();;
        put(2,1);
        System.out.println(cache.entrySet());
        put(1,1);
        System.out.println(cache.entrySet());
        put(2,3);
        System.out.println(cache.entrySet());
        put(4,1);
        System.out.println(cache.entrySet());
        System.out.println(get(1));
        System.out.println(cache.entrySet());
        System.out.println(get(2));
        System.out.println(cache.entrySet());
    }

    public static void LRUCacheCapacity() {
        cache = new LinkedHashMap<>(capacity);
    }
    
    public static int get(int key) {
        if(!cache.isEmpty() && cache.containsKey(key)){
            int value = cache.remove(key);
            cache.put(key,value);
            return value;
        }
        return -1;
    }
    
    public static void put(int key, int value) {
        if(!cache.isEmpty()){
            if(cache.containsKey(key)){
                cache.remove(key);
            }else if (cache.size() == capacity){
                int firstKey = cache.keySet().iterator().next();
                cache.remove(firstKey);
            }
        }
        cache.put(key,value);
    }
}
