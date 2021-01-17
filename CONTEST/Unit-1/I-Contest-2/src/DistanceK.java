import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class DistanceK {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(0 < t--)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n+1];
            HashMap<Integer,Integer> mp = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                arr[i] = sc.nextInt();
            }
            boolean flag = false;
            for (int i = 1; i <= n; i++) {
                if(mp.containsKey(arr[i]))
                {
                    if(Math.abs(mp.get(arr[i]) - i) <= k)
                    {
                        flag = true;
                        break;
                    }else
                    {
                        mp.put(arr[i],i);
                    }
                }else
                    mp.put(arr[i],i);
            }
            if(flag)
                System.out.println("YES");
            else
                System.out.println("NO");

        }
    }
}
