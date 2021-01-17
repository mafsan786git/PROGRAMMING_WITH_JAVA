
import java.util.Scanner;

public class RemoveDuplicate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(0 < t--){
            int n = sc.nextInt();
            int count = 0;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int j = 0;
            for (int i = 1; i <n ; i++) {
                if(arr[i-1] != arr[i])
                {
                    arr[++j] = arr[i];
                }
            }
            System.out.println(j+1);
            for (int i = 0; i <=j; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
