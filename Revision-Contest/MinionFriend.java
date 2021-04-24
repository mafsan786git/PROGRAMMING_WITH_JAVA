import java.util.*;
import java.io.*;
public class MinionFriend {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(input.nextToken());
        while(t-- > 0){
            input = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(input.nextToken());
            input = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(input.nextToken());
            }
            int lowest = Integer.MAX_VALUE;
            for (int i = 0; i < arr.length; i++) {
                lowest = Math.min(lowest, arr[i]);
            }
            long totalCost = 0;
            for (int i = 0; i < arr.length; i++) {
                totalCost += arr[i] - lowest;
            }
            System.out.println(totalCost);
        }
    }
}