import java.util.HashMap;
import java.util.Scanner;

public class MajorElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(0 < t--)
        {
            int n = sc.nextInt();
            int input;
            HashMap<Integer,Integer> hash = new HashMap<>();
            for (int i = 0; i < n; i++) {
                input = sc.nextInt();
                if(hash.containsKey(input))
                    hash.put(input,hash.get(input)+1);
                else
                    hash.put(input,1);
            }
            boolean flag = true;
            for (int x:hash.keySet())
            {
                if(hash.get(x) > Math.floor(n/2))
                {
                    flag = false;
                    System.out.print(x+" ");
                }

            }
            if (flag)
                System.out.println(-1);
            else
                System.out.println();

        }
    }
}
