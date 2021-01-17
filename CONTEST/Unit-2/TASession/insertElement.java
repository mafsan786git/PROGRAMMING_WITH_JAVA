import java.util.ArrayList;
import java.util.Arrays;

public class insertElement {
    public static void main(String[] args) {
        
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(2,3,4,6));
        InsertInSorted(arr,1);
        System.out.println(arr);
    }

    private static void InsertInSorted(ArrayList<Integer> arr, int k) {
        if(arr.size() == 0)
        {
            arr.add(k);
            return ;
        }
        if(arr.get(arr.size()-1)<= k)
        {
            arr.add(k);
            return ;
        }
        int temp = arr.remove(arr.size()-1);
        InsertInSorted(arr, k);
        arr.add(temp);
    }
}
