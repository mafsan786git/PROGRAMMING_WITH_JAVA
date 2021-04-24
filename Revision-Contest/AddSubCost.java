import java.util.*;

/**
 * You have an array consisting of N integers .You are allowed to perform 2 kinds of operation on this array.
    Type 1 : Increment any integer of the array by 1.
    Type 2 : Decrement any integer of the array by 1.
    You can perform these operation as many times as you want on this array.
    Each operation of Type 1 costs 3 while each operation of Type 2 costs 5.
    You want to have K equal elements in this array. What is the minimum cost required in obtaining K equal elements in this array?
 */
public class AddSubCost {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            long minCost = Long.MAX_VALUE;
            for (int i = 0; i <= arr.length-k; i++) {
                int mid = (i + i+ k-1)/2;
                long tempCost = 0;
                for (int j = i; j < i+k; j++) {
                    if(arr[j] > arr[mid]){
                        tempCost += (arr[j]-arr[mid])*5;
                    }else{
                        tempCost += (arr[mid]-arr[j])*3;
                    }
                }
                if(tempCost < minCost)
                    minCost = tempCost;
            }
            System.out.println(minCost);
            
        }
        sc.close();
    }
}
