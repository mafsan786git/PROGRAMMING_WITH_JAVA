import java.util.ArrayList;
import java.util.Scanner;

public class MaximumSumK {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n,k;
        n = sc.nextInt();
        k = sc.nextInt();
        ArrayList<Long> input = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            input.add(sc.nextLong());
        }
        if(k >= n)
        {
            for (int i = 1; i < n; i++) {
                input.set(i, input.get(i)+input.get(i-1));
            }
            System.out.println(input.get(n-1));
        }else
        {
            for (int i = 1; i < n; i++) {
                input.set(i, input.get(i)+input.get(i-1));
            }
            long sum = input.get(k-1);
            for (int i = k; i < n; i++) {
                long temp = input.get(i)-input.get(i-k);
                sum = Math.max(sum,temp);
            }
            System.out.println(sum);
        }
    }
}
