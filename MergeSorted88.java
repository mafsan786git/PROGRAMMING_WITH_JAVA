import java.util.Arrays;

public class MergeSorted88{
    /**
     * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, 
     * representing the number of elements in nums1 and nums2 respectively.
     * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
     * The final sorted array should not be returned by the function, but instead be stored inside the array nums1. 
     * To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, 
     * and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
     * 
     * Example : 
     * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     *
     * First Approach : 
     *  create new array with size m
     *  copy all the elements from num1
     * 
     * now start merging num3 and num2 in num1

     * @param args
     */
    public static void main(String[] args){
        int[] num1 = new int[]{6};
        int[] num2 = new int[0];
        // mergeSortedArray(num1,0,num2,1);
        // mergeSortedArrayWithoutSpace(num1,3,num2,3);
        mergeSortedArrayWithoutSpaceMoreCompact(num1,1,num2,0);
        System.out.println(Arrays.toString(num1));
    }
    //first apporach with appending in num2 and the sort
    //O(m+n)log(m+n)

    
    //using space
    private static void mergeSortedArray(int[] num1,int m, int[] num2,int n){
        int[] num3 = new int[m];
        for (int i = 0; i < m; i++) {
            num3[i] = num1[i];
        }
        int indexOfNum3 = 0;
        int indexOfNum2 = 0;
        int indexOfNum1 = 0;
        while (indexOfNum3 < num3.length && indexOfNum2 < num2.length) {
            if(num3[indexOfNum3] < num2[indexOfNum2]){
                num1[indexOfNum1] = num3[indexOfNum3];
                indexOfNum1++;
                indexOfNum3++;
            }else{
                num1[indexOfNum1] = num2[indexOfNum2];
                indexOfNum1++;
                indexOfNum2++;
            }
        }
        while(indexOfNum2 < num2.length){
            num1[indexOfNum1] = num2[indexOfNum2];
            indexOfNum1++;
            indexOfNum2++;
        }
        while(indexOfNum3 < num3.length){
            num1[indexOfNum1] = num3[indexOfNum3];
            indexOfNum1++;
            indexOfNum3++;
        }
    }
    //using two pointer without space
    private static void mergeSortedArrayWithoutSpace(int[] num1,int m, int[] num2,int n){
        int indexOfNum1 = m-1;
        int indexOfNum2 = n-1;
        int finalIndex = num1.length-1;
        while(indexOfNum1 >=0 && indexOfNum2 >= 0){
            if(num2[indexOfNum2] > num1[indexOfNum1]){
                num1[finalIndex] = num2[indexOfNum2];
                indexOfNum2--;
            }else{
                num1[finalIndex] = num1[indexOfNum1];
                indexOfNum1--;
            }
            finalIndex--;
        }
        while(indexOfNum2 >= 0){
            num1[finalIndex] = num2[indexOfNum2];
            finalIndex--;
            indexOfNum2--;
        }
        while(indexOfNum1 >= 0 ){
            num1[finalIndex] = num1[indexOfNum1];
            indexOfNum1--;
            finalIndex--;
        }
    }

    private static void mergeSortedArrayWithoutSpaceMoreCompact(int[] num1,int m, int[] num2,int n){
        int indexOfNum1 = m-1;
        int indexOfNum2 = n-1;
        int finalIndex = num1.length-1;
        while(indexOfNum2 >=0){
            if(indexOfNum1 >= 0 && num2[indexOfNum2] < num1[indexOfNum1]){
                num1[finalIndex] = num1[indexOfNum1];
                indexOfNum1--;
            }else{
                num1[finalIndex] = num2[indexOfNum2];
                indexOfNum2--;
            }
            finalIndex--;
        }
    }
}