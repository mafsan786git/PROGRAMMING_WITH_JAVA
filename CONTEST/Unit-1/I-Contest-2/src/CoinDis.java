import java.util.Scanner;

public class CoinDis {
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(0 < t--){
            long[] arr = new long[4];
            for (int i = 0; i < 4; i++) {
                arr[i] = sc.nextLong();
            }
            long mx = 0;
            for (int i = 0; i < 3; i++) {
                mx = Math.max(mx,arr[i]);
            }
            long sum = 0;
            for(int i=0;i<3;i++)
                sum += (mx-arr[i]);
            if(arr[3] < sum)
                System.out.println("NO");
            else
            {
                sum = arr[3] - sum;
                if(sum%3 == 0)
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }
    }
}
