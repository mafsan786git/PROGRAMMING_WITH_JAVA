import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class ColoringLine {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int t = Integer.parseInt(str[0]);
        while(0 < t--)
        {
            str = br.readLine().split(" ");
            int n = Integer.parseInt(str[0]);
            TreeMap<Long,Integer> mp = new TreeMap<>();
            long x,y;
            for(int i=0;i<n;i++){
                str = br.readLine().split(" ");
                x = Long.parseLong(str[0]);
                y = Long.parseLong(str[1]);
                if(mp.containsKey(x))
                    mp.put(x,mp.get(x)+1);
                if(mp.containsKey(y))
                    mp.put(y,mp.get(y)-1);
            }
        }
    }
}
