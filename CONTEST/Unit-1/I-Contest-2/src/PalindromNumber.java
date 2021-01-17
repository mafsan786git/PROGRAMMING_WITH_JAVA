import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PalindromNumber {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(0 < t--){
            int n = sc.nextInt();
            HashMap<Integer,Integer> mp = new HashMap<>();
            int odd = 0;
            for (int i = 0; i < n; i++){
                int input = sc.nextInt();
                if(mp.containsKey(input))
                    mp.put(input,mp.get(input)+1);
                else
                    mp.put(input,1);
            }

            for(Integer num : mp.keySet())
            {
                if(mp.get(num)%2 != 0)
                    odd++;
            }
            if(n%2 == 0){
                if (odd == 0) System.out.println("YES");
                else System.out.println("NO");
            }else
            {
                if(odd == 1) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }

}
