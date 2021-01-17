import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class GoodPair {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(0 < t--){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            long count = 0;
            HashMap<Integer,Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                if(map.containsKey(arr[i]))
                    count += map.get(arr[i]);
                if(map.containsKey(arr[i]*2))
                    map.put(arr[i]*2,map.get(arr[i]*2)+1);
                else
                    map.put(arr[i]*2,1);
            }
            System.out.println(count);
        }
    }

}
