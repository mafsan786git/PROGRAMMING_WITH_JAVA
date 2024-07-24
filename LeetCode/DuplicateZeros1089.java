
import java.util.*;
public class DuplicateZeros1089 {
    public static void main(String[] arg){
        int[] arr = new int[]{1,0,2,3,0,4,5,0};
        duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void duplicateZeros(int[] arr) {
        for(int index = 0;index < arr.length;index++){
            if(arr[index] == 0){
                int previousElement = 0;
                for(int tempIndex = index+1;tempIndex< arr.length ; tempIndex++){
                    int tempElement = previousElement;
                    previousElement = arr[tempIndex];
                    arr[tempIndex] = tempElement;
                }
                index++;
            }
        }
    }
}