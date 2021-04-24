
import java.util.HashSet;
import java.util.Scanner;

public class PairSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t  = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }
            HashSet<Integer> set = new HashSet<>();
            boolean flag = false;
            for (int i = 0; i < arr.length; i++) {
                int temp = k - arr[i];
                if(set.contains(temp))
                {
                    flag = true;
                    break;
                }
                set.add(arr[i]);
            }
            if(flag)
                System.out.println(1);
            else
                System.out.println(-1);
        }

        sc.close();
    }
    
}
