package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//Algorithm
/*
 * check if number[index] present in set
 * yes return the index
 * no  
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int[] answer = new int[2]; 
        int answerIndex = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int index = 0; index < numbers.length; index++) {
                if(map.containsKey(target-numbers[index])){
                    answer[answerIndex++] = map.get(target-numbers[index]);
                    answer[answerIndex] = index;
                    break;
                }
                map.put(numbers[index], index);
        }
        return answer;
    }
}
