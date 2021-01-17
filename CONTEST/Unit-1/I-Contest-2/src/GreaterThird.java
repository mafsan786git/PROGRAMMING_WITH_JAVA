import java.util.Scanner;

public class GreaterThird {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (0 < t--){
            int n = sc.nextInt();
            int []arr = new int[10001];
            for (int i = 0; i < n; i++) {
                arr[sc.nextInt()]++;
            }
            int count=0;
            for (int i = 0; i < n; i++) {
                if(arr[i] > n/3)
                    count++;
                else
                    arr[i] = -1;
            }
            System.out.println(count);
            for (int i = 0; i < n; i++) {
                if(arr[i] != -1)
                    System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
