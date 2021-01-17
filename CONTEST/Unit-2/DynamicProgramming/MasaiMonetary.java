import java.io.*;
import java.util.*;

public class MasaiMonetary {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input;
        while(true){
            try {
                input = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                break;
            }
            long n = Long.parseLong(input.nextToken());
            HashMap<Long,Long> set = new HashMap<>();
            System.out.println(maxExchange(n,0,set));
        }
    }
    private static long maxExchange(long n,long max,HashMap<Long,Long> map){
        if(n <= (long)1)
            return n;
        if(map.containsKey(n))
            return map.get(n);

        long temp1 = maxExchange(n/2, max, map);
        long temp2 = maxExchange(n/3, max, map);
        long temp3 = maxExchange(n/4, max, map);
        temp1 = temp1+temp2+temp3;
        map.put(n,Math.max(n,temp1));
        return Math.max(max, map.get(n));
    }
    
}
