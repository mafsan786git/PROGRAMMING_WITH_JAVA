import java.io.*;
import java.util.*;

public class EditDistanceRecur{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(input.nextToken());
        while(t-- > 0)
        {
            input = new StringTokenizer(br.readLine());
            String s1 = input.nextToken().toString();
            input = new StringTokenizer(br.readLine());
            String s2 = input.nextToken().toString();
            int longSub = longSubSequence(s1,s2,s1.length()-1,s2.length()-1);
            bw.write(longSub + "\n");
        }

        br.close();
        bw.close();
    }
    private static int longSubSequence(String s1,String s2,int i,int j){
        
        if(i < 0 || j < 0)
            return 0;
        
        int minDis = 0;
        if(s1.charAt(i) == s2.charAt(j))
            return longSubSequence(s1, s2, i-1, j-1);
        else{
            int insert = longSubSequence(s1, s2, i, j-1) +1 ;
            int remove = longSubSequence(s1, s2, i-1, j) + 1;
            int subtitute = longSubSequence(s1, s2, i-1, j-1) + 1;
            minDis =  Math.min(insert, Math.min(remove, subtitute));
            return minDis;
        }
    }
}