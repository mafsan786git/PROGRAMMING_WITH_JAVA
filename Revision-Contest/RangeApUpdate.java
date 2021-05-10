import java.io.*;
import java.util.*;

/**https://codeforces.com/blog/entry/86420 */
public class RangeApUpdate {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(input.nextToken());
        while(t-- > 0){
            input = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(input.nextToken());
            int q = Integer.parseInt(input.nextToken());
            int[] arr = new int[n+1];
            int[][] mat = new int[q][4];
            int k = 0;
            while(k < q){
                input = new StringTokenizer(br.readLine());
                mat[k][0]  = Integer.parseInt(input.nextToken());
                mat[k][1]  = Integer.parseInt(input.nextToken());
                mat[k][2]  = Integer.parseInt(input.nextToken());
                mat[k][3]  = Integer.parseInt(input.nextToken());
                k++;
            }
            for(int[] p : mat){
                arr[p[0]] += p[3];
                if(p[1]+1<=n) arr[p[1]+1] -= p[3];
            }
            for (int i = 1; i < arr.length; i++) {
                arr[i] += arr[i-1];
            }
            for(int[] p : mat){
                arr[p[0]] += p[2]-p[3];
                if(p[1]+1<=n) arr[p[1]+1] -= p[2]+(p[1]-p[0])*p[3];
            }
            for (int i = 1; i < arr.length; i++) {
                arr[i] += arr[i-1];
            }

            System.out.println(Arrays.toString(arr));
            
        }
    }
}
