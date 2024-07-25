
import java.util.*;
public class DuplicateZeros1089 {
    public static void main(String[] arg){
        int[] arr = new int[]{8,4,5,0,0,0,0,7};
        duplicateZerosOptimised_inplace(arr);
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

    public static void duplicateZerosOptimised(int[] arr){
        Queue<Integer> queue = new LinkedList<>();
        for (int num : arr) {
            queue.add(num);
        }
        for(int index = 0;index < arr.length;index++){
            int firstElement = queue.poll();
            arr[index] = firstElement;
            if(firstElement == 0){
                index++;
                if(index < arr.length){
                    arr[index] = 0;
                }
            }
        }
    }

    public static void duplicateZerosOptimised_inplace(int[] arr){
        int trimEndLength = 0;
        int length = arr.length-1;
        for(int index = 0;index <= length-trimEndLength;index++){
            if(arr[index] == 0){
                if(index == length-trimEndLength){
                    arr[length] = 0;
                    length--;
                    break;
                }
                trimEndLength++;
            }
        }
        int lastIndex = length-trimEndLength;
        for(int index = lastIndex;index >=0; index--){
            if(arr[index] == 0){
                arr[index+trimEndLength] = 0;
                trimEndLength--;
            }
            arr[index+trimEndLength] = arr[index];
        }
        System.out.println(trimEndLength);
    }
}