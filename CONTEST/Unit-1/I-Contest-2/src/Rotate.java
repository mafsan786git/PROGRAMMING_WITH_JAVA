import java.util.ArrayList;
import java.util.Scanner;

public class Rotate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(0 < t--)
        {
            long n,k;
            n = sc.nextInt();
            k = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                arr.add(sc.nextInt());
            }
            k = k%n;
            for (int i = 0; i < n; i++) {
                if(i < k){
                    System.out.print(arr.get((int)(n-k+i)) + " ");
                }else
                {
                    System.out.print(arr.get((int)(i-k)) + " ");
                }

            }
            System.out.println();

        }
    }
}
