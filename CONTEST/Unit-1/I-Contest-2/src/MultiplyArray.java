import java.util.ArrayList;
import java.util.Scanner;

public class MultiplyArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(0 < t--){
            int n = sc.nextInt();
            ArrayList<Long> input = new ArrayList<>();
            ArrayList<Long> mul = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                input.add(sc.nextLong());
                mul.add(input.get(i));
            }

            for (int i = 1; i < n; i++) {
                input.set(i,input.get(i)*input.get(i-1));
            }
            System.out.println(input);
            for (int i = n-2; i >=0; i--) {
                mul.set(i,mul.get(i)*mul.get(i+1));
            }
            System.out.println(mul);
            for (int i = 0; i < n && n > 1; i++) {
                if(i == 0 )
                    System.out.print(mul.get(i+1) + " ");
                else if(i == n-1)
                    System.out.print(input.get(i-1) + " ");
                else
                    System.out.print((input.get(i-1)*mul.get(i+1)) + " ");
            }
            if(n == 1)
                System.out.print(input.get(0));
            System.out.println();
        }
    }
}
