import java.util.Scanner;
/**Given an array A of size n with positive numbers, find the total number of subarrays that have sum < m. */
public class TotalSubArrayLessThanK {
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

            int count = 0;
            int start = 0;
            int end = 0;
            int sum = arr[start];
            while(start < n && end < n) {
                if(sum < k){
                    end++;
                    if(end >= start)
                        count += end - start;
                    if(end < n)
                        sum += arr[end];
                }else{
                    sum -= arr[start];
                    start++;
                }
            }
            System.out.println(count);
        }
        sc.close();
    }

}
