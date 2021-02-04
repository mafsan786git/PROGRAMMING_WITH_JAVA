import java.util.Scanner;
public class CountTriplet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr =new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int count = 0;
        for (int i = 0; i < arr.length-2; i++) {
            int cur = upperBound(arr,k,i+2);
            if(cur != -1){
                count += ((cur-i)*(cur-i-1))/2;
            }
        }
        System.out.println(count);
        sc.close();
    }

    private static int upperBound(int[] arr, int k, int low) {
        int curElement = arr[low-2];
        int high = arr.length-1;
        int mid = 0,ans = -1;
        while(low <= high){
            mid =low+(high-low)/2;
            if((arr[mid]-curElement) <= k){
                ans = mid;
                low = mid+1;
            }else
                high = mid-1;
        }
        return ans;
    }
    
}
