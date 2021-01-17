
import java.util.ArrayList;


public class SubSet {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4};
        // ArrayList<ArrayList<Integer>> Output = new ArrayList<>();
        allSubsetsOrder(arr, 0, new ArrayList<>());
        // allSubsetsUnorder(arr, 0, new ArrayList<>());
    }

    // Unsorted
    private static void allSubsetsUnorder(int[] arr, int index, ArrayList<Integer> list) {
        if (index == arr.length) {
            System.out.println(list);
            return;
        }

        allSubsetsUnorder(arr, index + 1, list);
        list.add(arr[index]);
        allSubsetsUnorder(arr, index + 1, list);
        list.remove(list.size() - 1);

    }

    // This is in Order
    private static void allSubsetsOrder(int[] arr, int index, ArrayList<Integer> list) {
        System.out.println(list);
        for (int i = index; i < arr.length; i++) {
            list.add(arr[i]);
            allSubsetsOrder(arr, i + 1, list);
            list.remove(list.size()-1);
        }
    }
    
    
}
