import java.util.HashMap;
import java.util.Scanner;

public class Jerry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(0 < t--)
        {
            int n = sc.nextInt();
            int x,y;
            HashMap<Integer,Integer> mp = new HashMap<>();
            for (int i = 0; i < n; i++) {
                x = sc.nextInt();
                y = sc.nextInt();
                int mx = Math.max(x,y);
                if(mp.containsKey(mx))
                    mp.put(mx,mp.get(mx)+1);
                else
                    mp.put(mx,1);
            }
            int mx = Integer.MAX_VALUE;
            for (Integer key : mp.keySet())
            {
                mx = Math.min(key,mx);
            }
            System.out.println(mp.get(mx));
        }
    }
}
