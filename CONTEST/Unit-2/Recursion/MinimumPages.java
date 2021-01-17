import java.util.HashMap;
import java.util.Scanner;

public class MinimumPages {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // System.out.println(Math.round(1/(double)2));
        int t = sc.nextInt();
        while(t-- > 0){
            HashMap<Integer,Integer> map = new HashMap<>();
            int n = sc.nextInt();
            int min = Integer.MAX_VALUE;
            int temp = PagesMin(map,n,min);
    
            if(temp >= 999)
                System.out.println(-1);
            else
                System.out.println(temp-1);
        }
    }

    private static int PagesMin(HashMap<Integer, Integer> map, int n,int min) {
        if(n == 0)
            return 1;
        if(n < 0)
            return (Integer)999;
        if(map.containsKey(n))
            return map.get(n);
        int temp1 = 1,temp2 = 1;
        temp1 += PagesMin(map, n-10,min);
        temp2 += PagesMin(map, n-12,min);
        
        map.put(n,Math.min(temp1,temp2));
        return map.get(n);
    }
    
}
