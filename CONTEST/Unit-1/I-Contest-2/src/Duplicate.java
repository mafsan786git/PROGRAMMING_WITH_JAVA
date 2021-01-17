
import java.util.HashSet;
import java.util.Scanner;

public class Duplicate {
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(0 < t--){
            int n = sc.nextInt();
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++)
                set.add(sc.nextInt());
            if(n == set.size())
                System.out.println("NO");
            else
                System.out.println("YES");
        }
    }
}
