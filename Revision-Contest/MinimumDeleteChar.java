import java.io.*;
import java.util.*;

public class MinimumDeleteChar {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(input.nextToken());
        while(t-- > 0){
            input = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(input.nextToken());
            input = new StringTokenizer(br.readLine());
            String str = input.nextToken();
            int[] arr = new int[26];
            for (int i = 0; i < str.length(); i++) {
                arr[str.charAt(i)-'a']++;
            }
            System.out.println(Arrays.toString(arr));
            int[] map = new int[1000001];
            for (int i = 0; i < 26; i++) {
                if(arr[i] == 0)
                    continue;
                map[arr[i]]++;
            }
            long ans = 0;//sweldgscyrjhftcxhhhimzubppcfnpzutt
            for(int i = map.length-1; i >=0 ; i--){
                if(map[i] != 0 && map[i] != 1){
                    int key = map[i]-1;
                    int j=0;
                    if(i == 1)
                    {
                        ans += key;
                        break;
                    }
                    for (j = 1; j<= key && j<i; j++) {
                        if(map[i-j] == 0)
                            map[i-j] = 1;   
                        if(j+1 >= i)
                            break;
                    }
                    ans += i * (key-j);
                }
            }
            System.out.println(ans);
        }
    }
}
