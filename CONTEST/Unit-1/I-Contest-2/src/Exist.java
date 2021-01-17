import java.util.Scanner;

public class Exist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int sub[] = {0, 1, 2, 3};
        while( 0 < t--)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int j=0;
            for (int i = 0; i < n; i++) {
                if(sub[j] == arr[i])
                    j++;
                if(j == 4)
                    break;
            }
            if(j == 4)
                System.out.println("YES");
            else
                System.out.println("NO");


        }
    }
}
