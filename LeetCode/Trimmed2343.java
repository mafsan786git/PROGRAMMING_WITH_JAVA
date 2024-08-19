import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
public class Trimmed2343 {
    public static void main(String[] arg){
        String[] nums = new String[]{"9415","5908","1840","5307"};
        int[][] q = new int[][]{
            {3,2},{2,2},{3,3},{1,3},{3,4}
        };
        System.out.println(Arrays.toString(radixSortWithQueries(nums,q)));
    }

    private static int[] radixSortWithQueries(String[] nums, int[][] queries){
        int maxPlaceVal = Integer.MIN_VALUE;
        for (int[] query : queries) {
            maxPlaceVal = Integer.max(maxPlaceVal, query[1]);
        }
        Map<Integer,String[]> sortedMap = new HashMap<>();
        int placeVal = 1;
        String[] tempArray = nums.clone();
        while(placeVal <= maxPlaceVal){
            String[] sortedArray = countingSort(tempArray,placeVal);
            sortedMap.put(placeVal, sortedArray.clone());
            placeVal++;
        }
        for(Map.Entry<Integer,String[]> entry : sortedMap.entrySet()){
            System.err.println(entry.getKey() + " --- " + Arrays.toString(entry.getValue()));
        }
        int[] answer = new int[queries.length];
        for (int index = 0;index < queries.length;index++) {
            String[] sortedArray = sortedMap.get(queries[index][1]);
            answer[index] = getKthSmallestStringIndex(sortedArray,queries[index][0],nums);
        }
        return answer;

    }

    private static int getKthSmallestStringIndex(String[] sortedArray,int k,String[] nums){
        String smallestString = sortedArray[k-1];
        int index = k-2;
        int smallestStringPosition = 1;
        while(index >= 0 && sortedArray[index].equalsIgnoreCase(smallestString)){
            smallestStringPosition++;
            index--;
        }
        int countOfSmallestString = 0;
        for(int i = 0;i < nums.length;i++){
            if(nums[i].equals(smallestString)){
                countOfSmallestString++;
                if(countOfSmallestString == smallestStringPosition) return i;
                
            }
        }
        return 0;
    }

    private static String[] countingSort(String[] tempNums,int placeVal){
        int base = 10;
        int[] countSort = new int[base];
        for(String val: tempNums){
            int currentIndex = calculateCurrentIndex(val,placeVal);
            countSort[currentIndex] += 1;
        }

        int startIndex = 0;
        for(int index = 0;index < base ; index++){
            int count  = countSort[index];
            countSort[index] = startIndex;
            startIndex += count;
        }

        String[] sortedArray = new String[tempNums.length];
        for(String val : tempNums){
            int currentIndex = calculateCurrentIndex(val,placeVal);
            sortedArray[countSort[currentIndex]] = val;
            countSort[currentIndex] += 1;
        }
        System.arraycopy(sortedArray, 0, tempNums, 0, tempNums.length);
        return sortedArray;
    }
    
    private static int calculateCurrentIndex(String val,int placeVal){
        return val.charAt(val.length() - placeVal) - '0';
    }
}