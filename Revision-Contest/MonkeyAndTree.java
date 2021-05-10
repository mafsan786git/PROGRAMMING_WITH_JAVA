import java.io.*;
import java.util.*;

public class MonkeyAndTree {
    private static int minStep = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(input.nextToken());
        int start = Integer.parseInt(input.nextToken());
        int banana = Integer.parseInt(input.nextToken());
        int up = Integer.parseInt(input.nextToken());
        int down = Integer.parseInt(input.nextToken());
        climbTree(height, start, banana, up, down, 0);
        System.out.println(minStep);

    }
    private static void climbTree(int h,int s,int b,int u,int d,int count){
        if(s == b){
            Math.min(minStep, count);
            return ;
        }
        if(s > h || s < 0)
            return ;
        
        climbTree(h, s+u, b, u, d, count+1);
        climbTree(h, s-d, b, u, d, count+1);
    }
    
}
