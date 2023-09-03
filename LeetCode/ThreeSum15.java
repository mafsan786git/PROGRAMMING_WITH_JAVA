import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class ThreeSum15 {
    /**
     * [-1,0,1,2,-1,-4]
     * start from first :
     *      start from first+1 : 
     *          find the pair which sum to the first
     * 
     * -2 , 1, 1
     * -2 ----- +2
     *  2-1 == 1
     * 1
     * map {
     *     1 - i=1
     *      
     * }
     */

    public static void main(String[] args){
        int[] nums = new int[]{0,0,0};
        int[] nums2 = new int[]{-4,-1,-1,-1,0,1,2,2,2,2,3,3,3,3,4,4,-4,-5,-5,5,6,6,6,7,7};
        //-4,-1,-1,-1,0,1,2,2
        Arrays.sort(nums2);
        List<List<Integer>> tripletList = findAllTheTripletsInhanced(nums2);
        System.out.println(tripletList);
    }

    public static List<List<Integer>> findAllTheTriplets(int[] nums){
        List<List<Integer>> tripletList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            int sum = -nums[i];
            Map<Integer,Integer> tripletMap = new HashMap<>();
            for (int j = i+1; j < nums.length; j++) {
                if (tripletMap.containsKey(nums[j])) {
                    int index = tripletMap.get(nums[j]);
                    if(index != -1){
                        List<Integer> answer = new ArrayList<>();
                        answer.addAll(List.of(nums[i],nums[index],nums[j]));
                        tripletList.add(answer);
                        tripletMap.put(nums[j], -1);
                        continue;
                    }
                }else{
                    tripletMap.put(sum-nums[j], j);
                }
            }
        }
        return tripletList;
    }

    //Time will be same but comparing will be reduced
    public static List<List<Integer>> findAllTheTripletsInhanced(int[] nums){
        List<List<Integer>> tripletList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            int left = i+1;
            int right = nums.length-1;
            while(left < right){
                if(nums[i] + nums[left] + nums[right] < 0){
                    left++;
                }else if(nums[i] + nums[left] + nums[right] > 0){
                    right--;
                }else{
                    tripletList.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while(left < right && nums[left] == nums[left+1]) left++;
                    while(left < right && nums[right] == nums[right-1]) right--;
                    left++;
                    right--;
                }
            }
        }
        return tripletList;
    }


}
