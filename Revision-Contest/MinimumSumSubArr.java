import java.util.*;

/**
 * left decreasing stack and right decreasing stack
 * minimum subarray sum
 * https://leetcode.com/problems/sum-of-subarray-minimums/ 
 */

public class MinimumSumSubArr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(minimumSum(arr,n));
        sc.close();
    }

    private static int minimumSum(int[] arr, int n) {
        int[] leftLess = new int[n];
        int[] rightLess = new int[n];
        Stack<Integer> st = new Stack<>();

        //previous less to the left
        for (int i = 0; i < n; i++) {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            leftLess[i] = st.isEmpty() ? i+1: i -st.peek();
            st.push(i);

        }
        st.clear();
        //right less to the right side
        for (int i = n-1; i >= 0; i--) {
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }
            rightLess[i] = st.isEmpty() ? n-i: st.peek()-i;
            st.push(i);
        }
        long sum = 0;
        long mod = (int)1000000007;
        for (int i = 0; i < rightLess.length; i++) {
            sum = (sum + (long)arr[i]*leftLess[i]*rightLess[i])%mod;
        }
        return (int)sum;
    }
}
