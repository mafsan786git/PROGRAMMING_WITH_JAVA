import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Football {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<String,Integer> mp = new HashMap<>();
        sc.nextLine();
        while(n>0)
        {
            ArrayList<Integer> array = new ArrayList<Integer>();
            String s = sc.nextLine();
            if(mp.containsKey(s))
                mp.put(s,mp.get(s)+1);
            else
                mp.put(s,1);
            n--;
        }
        int val = 0;
        String s1 = null;
        for(String s : mp.keySet())
        {
            if (val<mp.get(s))
            {
                val= mp.get(s);
                s1 = s;
            }
        }
        System.out.println(s1);
    }
}
