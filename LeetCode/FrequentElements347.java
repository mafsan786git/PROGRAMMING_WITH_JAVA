import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


public class FrequentElements347 {
    public static void main(String[] args){
        int[] answer = topKFrequentElementUsingPQ(new int[]{1,1,1,2,2,3},2);
        System.out.println(Arrays.toString(answer));
    }

    public static int[] topKFrequentElementUsingPQ(int[] arr,int k){
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(k+1,new Comparator<Map.Entry<Integer,Integer>>() {
            @Override
            public int compare(Map.Entry<Integer,Integer> o1, Map.Entry<Integer,Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        Map<Integer,Integer> hasMap = new HashMap<>();

        for(int index = 0; index < arr.length;index++){
            hasMap.put(arr[index], hasMap.containsKey(arr[index]) ? hasMap.get(arr[index]) + 1 : 1);
        }
        for(Map.Entry<Integer,Integer> keyValue : hasMap.entrySet()){
            pq.add(keyValue);
            if(pq.size() > k){
                pq.poll();
            }
        }
        int[] answer = new int[k];
        for(int index = k-1;index >=0; index--){
            Map.Entry<Integer,Integer> entry  =  pq.poll();
            answer[index] = entry.getKey();
        }
        return answer;
    }
}
