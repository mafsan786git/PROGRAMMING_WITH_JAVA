
import java.util.Scanner;


public class QuerySum {
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 1; i < n; i++) {
            arr[i] = arr[i-1] +arr[i] ;
        }
        int q = sc.nextInt();
        while( 0 < q--){
            int l = sc.nextInt();
            int r = sc.nextInt();
            l--;r--;
            if(l !=0 )
                System.out.println(arr[r] - arr[l-1]);
            else
                System.out.println(arr[r]);
        }
    }
}
