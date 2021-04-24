import java.util.*;
import java.io.*;

public class StringAndMatrix {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(input.nextToken());
        while(t-- > 0){
            input = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(input.nextToken());
            int m = Integer.parseInt(input.nextToken());
            char[][] arr = new char[n][26];
            for (int i = 0; i < n; i++) {
                input = new StringTokenizer(br.readLine());
                String temp = input.nextToken();
                for (int j = 0; j < temp.length(); j++) {
                    arr[i][temp.charAt(j)-'a']++;
                }
            }
            input = new StringTokenizer(br.readLine());
            String str = input.nextToken();
            boolean flag = true;
            for (int i = 0; i < m ;i++) {
                int pos = i%n;
                if(arr[pos][str.charAt(i)-'a'] == 0)
                {
                    flag = false;
                    break;
                }
                arr[pos][str.charAt(i)-'a']--;
            }
            if(flag)
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }
}
