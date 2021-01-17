
import java.util.Scanner;
import java.util.HashMap;

public class LowestMode {
    public static void main(String [] arg){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(0 < t--){
            int n = sc.nextInt();
            HashMap<Integer,Integer> mp = new HashMap<>();
            while(0 < n--){
                int input = sc.nextInt();
                if(mp.containsKey(input))
                    mp.put(input,mp.get(input)+1);
                else
                    mp.put(input,1);
            }
            int mx = Integer.MIN_VALUE;
            int mode = Integer.MAX_VALUE;
            for(Integer key : mp.keySet())
            {
                if(mp.get(key) > mx)
                {
                    mx = mp.get(key);
                    mode = key;
                }else if(mp.get(key) == mx)
                {
                    mode = Math.min(mode,key);
                }
            }
            System.out.println(mode);
        }
    }
}
