import java.io.*;
import java.util.StringTokenizer;

public class MaximumContSubarray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(input.nextToken());
        while (t-- > 0) {
            input = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(input.nextToken());
            long[] arr = new long[n];
            input = new StringTokenizer(br.readLine());
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Long.parseLong(input.nextToken());
            }
            long mxSubSum = 0;
            long sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum = Math.max(arr[i], arr[i]+sum);
                mxSubSum = Math.max(mxSubSum, sum);
            }
            System.out.println(mxSubSum);
        }
    }
}
