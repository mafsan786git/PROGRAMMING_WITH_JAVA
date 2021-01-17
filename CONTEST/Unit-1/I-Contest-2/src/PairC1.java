import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class PairC1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int t = Integer.parseInt(input[0]);
        while(0 < t--){
            input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            input = br.readLine().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }
            HashMap<Integer,Integer> map = new HashMap<>();
            int count=0;
            for (int i = 0; i < n; i++) {
                if(map.containsKey(5*arr[i]))
                    map.put(5*arr[i],map.get(5*arr[i])+1);
                else
                    map.put(5*arr[i],1);
            }
            for (int i = 0; i < n; i++) {
                if(arr[i] == 0)
                    continue;
                int temp = 0;
                temp = 4*arr[i];
                if(map.containsKey(temp))
                {
                    count += map.get(temp);
                }
            }
//            System.out.println(Arrays.toString(arr));
//            System.out.println(map);
            if(map.containsKey(0)){
                count += (map.get(0)*(map.get(0)-1))/2;
            }
            System.out.println(count);
        }
    }

}
