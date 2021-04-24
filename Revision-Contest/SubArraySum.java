import java.util.HashMap;
import java.util.Scanner;
/**You are given an array of N integers and a single integer K. You need to find out if there is a subarray, which has the sum exactly as K. */
public class SubArraySum {
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
            HashMap<Integer,Integer> map = new HashMap<>();
            int res = 0;
            int currSum = 0;
            for (int i = 0; i < arr.length; i++) {
                currSum += arr[i];
                if(currSum == k)
                    res++;

                if(map.containsKey(currSum-k)){
                    res += map.get(currSum-k);
                }

                Integer count = map.get(currSum);
                if(count == null){
                    map.put(currSum,1);
                }else{
                    map.put(currSum, count+1);
                }
            }
            System.out.println(res);
        }
        sc.close();
    }
/** nlog(n) process and O(1) space;
 *      for (int i = 1; i < arr.length; i++) {
            arr[i] += arr[i-1];
        }
 *      boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == k){
                flag = true;
                break;
            }
            if(isPresent(arr, i,k)){
                flag = true;
                break;
            }
        }
    public static boolean isPresent(int[] arr,int idx,int target){
        int left = 0;
        int right = idx-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if((arr[idx] - arr[mid]) == target)
                return true;
            if((arr[idx] - arr[mid]) < target)
                right = mid-1;
            else
                left = mid+1;
        }
        return false;
    }
*/
    
}
