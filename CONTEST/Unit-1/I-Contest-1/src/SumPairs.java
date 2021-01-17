import java.util.HashMap;
import java.util.Scanner;

public class SumPairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = sc.nextInt();
        int []arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();
        int count =0;
        /*for (int i = 0; i < n; i++) {
            int rem = sum-arr[i];
            for (int j = i+1; j < n; j++) {
                if(rem == arr[j])
                    count++;
            }
        }*/
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int rem = sum-arr[i];
            if(mp.containsKey(rem))
                count += mp.get(rem);
            if (mp.containsKey(arr[i]))
                mp.put(arr[i],mp.get(arr[i])+1);
            else
                mp.put(arr[i],1);

        }
        System.out.println(count);
    }
}
