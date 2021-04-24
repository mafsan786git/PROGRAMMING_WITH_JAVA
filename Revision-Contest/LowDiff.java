import java.util.PriorityQueue;
import java.util.Scanner;

public class LowDiff {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pq.add(sc.nextInt());
        }
        int left = 0;
        int right = n-1;
        while(pq.isEmpty() == false){
            arr[left++] = pq.poll();
            if(right <= left)
                continue;
            arr[right--] = pq.poll();
        }
        int dangerValue = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            dangerValue = Math.max(dangerValue, Math.abs(arr[i]-arr[i-1]));
        }
        dangerValue = Math.max(dangerValue, Math.abs(arr[n-1] - arr[0]));
        // System.out.println(Arrays.toString(arr));
        System.out.println(dangerValue);
        sc.close();
    }
}
