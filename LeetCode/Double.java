
import java.util.HashSet;
import java.util.Set;




public class Double {
    public static void main(String[] args) {
        int[] nums = new int[]{10,2,5,3};
        System.out.println(checkIfExist(nums));
    }

    public static boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for(int index = 0;index < arr.length; index++){
            if(set.contains(arr[index]*2)) return true;
            set.add(arr[index]*2);
            set.add(arr[index]);
        }
        return false;
    }

}