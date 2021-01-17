import java.io.*;
import java.util.*;

/*
PROBLEM STATEMENT----
    You have an array consisting of N integers .You are allowed to perform 2 kinds of operation on this array.
    Type 1 : Increment any integer of the array by 1.
    Type 2 : Decrement any integer of the array by 1.
    You can perform these operation as many times as you want on this array.
    Each operation of Type 1 costs 3 while each operation of Type 2 costs 5.
    You want to have K equal elements in this array. What is the minimum cost required in obtaining K equal elements in this array?

TIME COMPLEXITY----
    O(N*(MAX-MIN))

*/

public class AddSubtract {
    static int[] StringToInt(StringTokenizer input){
        int[] arr = new int[input.countTokens()];
        int i=0;
        while(input.hasMoreTokens())
            arr[i++] = Integer.parseInt(input.nextToken());
        return arr;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(input.nextToken());
        while(t-- > 0){
            input = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(input.nextToken());
            int k = Integer.parseInt(input.nextToken());
            input = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            arr = StringToInt(input);
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < arr.length; i++) {
                min = Math.min(min, arr[i]);
                max = Math.max(max, arr[i]);
            }
            
            int minCost = Integer.MAX_VALUE;
            ArrayList<Integer> equalArray = new ArrayList<>();
            for (int i = min; i <=max; i++) {
                equalArray.clear();
                for (int j = 0; j < arr.length; j++) {
                    if(i < arr[j]){
                        equalArray.add(Math.abs(i-arr[j])*5);
                    }else
                        equalArray.add(Math.abs(i-arr[j])*3);
                }
                Collections.sort(equalArray);
                int total = 0;
                for (int j = 0; j < k; j++) {
                    total += equalArray.get(j);
                }
                minCost = Math.min(minCost, total);
            }

            System.out.println(minCost);


        }
    }
    
}
