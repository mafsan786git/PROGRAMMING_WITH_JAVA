import java.util.Scanner;

public class PowerOfTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println((int)Math.ceil((double)n/2));
        System.out.println(reorderedPowerOf2(n));
        sc.close();
        
    }
    public static boolean reorderedPowerOf2(int N) {
        long c = counter(N);
        for (int i = 0; i < 32; i++)
        {
            int num = 1 << i;
            long temp = counter(num);
            if (temp == c) return true;
        }
        return false;
    }
    public static long counter(int N) {
        long res = 0;
        for (; N > 0; N /= 10) res += (int)Math.pow(10, N % 10);
        return res;
    }
    
}
