import java.util.PriorityQueue;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

public class SlidingWindowMax239 {
    public static void main(String[] args) {
        int[] answer = maxValuesOptimsed(new int[]{1,3,-1,-3,5,3,6,7}, 3);
        System.out.println(Arrays.toString(answer));
    }

    public static int[] maxValuesOptimsed(int[] nums,int k){
        int[] answer = new int[nums.length-k+1];
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int answerIndex = 0;
        int left = 0;
        int right = 0;
        while(right < nums.length){
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[right]){
                dq.removeLast();
            }
            dq.add(right);
            if(left > dq.peekFirst()){
                dq.removeFirst();
            }
            if(right + 1 >= k){
                answer[answerIndex++] = nums[dq.getFirst()];
                left++;
            }
            right++;
        }
        return answer;
    }

    public static int[] maxValues(int[] nums,int k){
        int[] answer = new int[nums.length-k+1];
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer,Integer>>(){
            @Override
            public int compare(Map.Entry<Integer,Integer> o1,Map.Entry<Integer,Integer> o2){
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        for(int i=0;i<k;i++){
            Map.Entry<Integer,Integer> newEntry = Map.entry(i,nums[i]);
            pq.add(newEntry);
        }
        Map.Entry<Integer,Integer> resultEntry = pq.peek();
        int answerIndex = 0;
        answer[answerIndex++] = resultEntry.getValue();
        int left = 1;
        int right = k;
        while(right < nums.length){
            Map.Entry<Integer,Integer> newEntry = Map.entry(right,nums[right]);
            pq.add(newEntry);
            while(!pq.isEmpty()){
                Map.Entry<Integer,Integer> tempRes = pq.peek();
                if(tempRes.getKey() >= left){
                    break;
                }
                pq.remove();
            }
            resultEntry = pq.peek();
            answer[answerIndex++] = resultEntry.getValue();
            left++;
            right++;
        }
        return answer;
    }
}
