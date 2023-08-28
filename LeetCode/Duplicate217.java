import java.util.HashSet;
import java.util.Set;

public class Duplicate217 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        containsDuplicate(nums);
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> unique = new HashSet<>();
        for (Integer value : nums) {
            if(unique.contains(value)){
                return true;
            }
            unique.add(value);
        }
        return false;
    }

}
