import java.util.Scanner;

public class MagicPattern {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(0 < t--){
            int n = sc.nextInt();
            int zeros = 0;
            int ones = 0;
            for (int i = 0; i < n; i++) {
                int temp = sc.nextInt();
                if(temp == 0)
                    zeros++;
                else
                    ones++;
            }
            while( zeros > 0 && 0 < ones ) {
                System.out.print(0 + " " + 1 + " ");
                zeros--;
                ones--;
            }
            while( 0 < zeros--)
                System.out.print(0 + " ");
            while( 0 < ones--)
                System.out.print(1 + " ");
            System.out.println();
        }
    }
}
