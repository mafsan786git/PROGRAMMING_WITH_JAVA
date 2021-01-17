import java.util.ArrayList;
import java.util.Arrays;

public class SortArray {
    public static void main(String[] args){
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        sortArrayUsingRecursion(arr);
        System.out.println(arr);
    }

    private static void sortArrayUsingRecursion(ArrayList<Integer> arr){
        if(arr.size() == 1)
            return ;
        int temp = arr.remove(arr.size()-1);
        sortArrayUsingRecursion(arr);
        insertInSorted(arr,temp);
    }

    private static void insertInSorted(ArrayList<Integer> arr,int k)
    {
        if(arr.size() == 0 || arr.get(arr.size()-1) <= k )
        {
            arr.add(k);
            return ;
        }
        int temp = arr.remove(arr.size()-1);
        insertInSorted(arr, k);
        arr.add(temp);

    }
}
