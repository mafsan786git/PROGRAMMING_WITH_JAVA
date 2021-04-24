import java.util.Arrays;
import java.util.Scanner;

public class CountTriplets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long target = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextLong();
        }
        Arrays.sort(arr);


        long count = 0;
        for (int i = 0; i < arr.length-2; i++) {
            
            int idx = isLowest(arr,i+2,target);

            if(idx != -1){
                count += (idx-i)*(idx-i-1)/2;  
            }
        }
        System.out.println(count);
        sc.close();
    }

    private static int isLowest(long[] arr, int i, long target) {
        int left = i;
        int right = arr.length-1;
        int ans = -1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if((arr[mid] - arr[i-2]) <= target){
                ans = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }

        return ans;
    }
    
}
