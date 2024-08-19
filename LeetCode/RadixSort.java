
import java.util.Arrays;


public class RadixSort {
    private final static int base = 10;
    public static void main(String[] arg){
        int[] arr = new int[]{336,256,736,443,831,907};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void radixSort(int[] arr){
        int maxVal = Arrays.stream(arr).max().getAsInt();
        int placeVal = 1;
        while(maxVal/placeVal > 0){
            countingSort(arr,placeVal);
            placeVal *= 10;
        }
    }

    private static void countingSort(int[] arr,int placeVal){
        int[] countingSort = new int[base];
        for(int num : arr){
            int count = num/placeVal;
            countingSort[count%base] += 1;
        }


        int startIndex = 0;
        for(int index = 0;index < base; index++){
            int count  = countingSort[index];
            countingSort[index] = startIndex;
            startIndex += count;
        }

        int[] sortedArray = new int[arr.length];
        for(int num : arr){
            int count = num/placeVal;
            sortedArray[countingSort[count%base]] = num;
            countingSort[count%base] += 1;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sortedArray[i];
        }

    }
}