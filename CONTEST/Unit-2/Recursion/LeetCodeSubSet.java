import java.util.*;
public class LeetCodeSubSet {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,2};
        List<List<Integer>> output = new ArrayList<>();
        // backtrack(output,new ArrayList<>(),3,1);
        // for(List<Integer> list : output)
        //     System.out.println(list);
        backtrackDuplicate(new ArrayList<>(), arr, 0);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<Integer>());
        // System.out.println(output);
        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList<>();
            for (List<Integer> curr : output) {
                List<Integer> newCurr = new ArrayList<>(curr);
                newCurr.add(num);
                newSubsets.add(new ArrayList<Integer>(newCurr));
            }
            // System.out.println(newSubsets);
            for (List<Integer> curr : newSubsets) {
                output.add(curr);
            }
            // System.out.println(output);
        }
        return output;
    }

    //normal----
    private static void backtrack(List<List<Integer>> list , List<Integer> tempList, int nums, int start){
        for(Integer val : tempList)
            System.out.print(val + " ");
        System.out.println();
        for(int i = start; i <= nums; i++){
            tempList.add(i);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    //without Duplicate
    private static void backtrackDuplicate(List<Integer> tempList, int [] nums, int start){
        System.out.println(tempList);
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
            tempList.add(nums[i]);
            backtrackDuplicate(tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
    
}
