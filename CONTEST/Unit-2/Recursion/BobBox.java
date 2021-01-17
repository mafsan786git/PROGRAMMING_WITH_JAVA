import java.util.Scanner;

public class BobBox {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(NumberOfWays(n));
        sc.close();
    }

    private static int NumberOfWays(int n) {
        if(n == 0)
            return 1;
        if(n < 0)
            return 0;
        
        return NumberOfWays(n-1) + NumberOfWays(n-3) + NumberOfWays(n-5);
    }
    
}
