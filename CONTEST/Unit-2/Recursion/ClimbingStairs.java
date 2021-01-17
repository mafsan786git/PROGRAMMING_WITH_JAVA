import java.util.Scanner;

public class ClimbingStairs {

    public static int CountWays(int n){
        if(n==0)
            return 1;
        if(n < 0)
            return 0;
        return CountWays(n-1) + CountWays(n-2) + CountWays(n-3);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(CountWays(n));

        sc.close();
    }
    
}
