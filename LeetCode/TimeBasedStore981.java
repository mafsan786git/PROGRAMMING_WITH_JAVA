import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TimeBasedStore981 {
    Map<String,ArrayList<AbstractMap.SimpleEntry<Integer,String>>> timeBasedMap;

    public TimeBasedStore981() {
        timeBasedMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        timeBasedMap.compute(key, (keyMap,valuesList) -> {
            if(valuesList == null){
                ArrayList<AbstractMap.SimpleEntry<Integer,String>> newList = new ArrayList<>();
                newList.add(new AbstractMap.SimpleEntry<Integer,String>(timestamp, value));
                return newList;
            }else{
                valuesList.add(new AbstractMap.SimpleEntry<>(timestamp,value));
                return valuesList;
            }
        });
    }
    
    public String get(String key, int timestamp) {
        if(timeBasedMap == null || timeBasedMap.isEmpty() || !timeBasedMap.containsKey(key)){
            return "";
        }
        ArrayList<AbstractMap.SimpleEntry<Integer, String>> arrayList = timeBasedMap.get(key);
        int left = 0;
        int right = arrayList.size()-1;
        String value = "";
        while(left <= right){
            int mid = left + (right-left)/2;
            AbstractMap.SimpleEntry<Integer, String> simpleEntry = arrayList.get(mid);
            if(simpleEntry.getKey() == timestamp)
                return simpleEntry.getValue();

            if(simpleEntry.getKey() > timestamp){
                right = mid-1;
            }else {
                value = simpleEntry.getValue();
                left = mid+1;
            }
        }
        return value;
    }
}
