import java.io.*;
import java.util.*;
public class TemplateForInput {
    static int[] StringToInt(StringTokenizer input){
        int[] arr = new int[input.countTokens()];
        int i=0;
        while(input.hasMoreTokens())
            arr[i++] = Integer.parseInt(input.nextToken());
        return arr;
    }
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        // BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(input.nextToken());
        while(t-- > 0)
        {
            input = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(input.nextToken());
            int[][] shops = new int[n][3];
            for (int i = 0; i < shops.length; i++) {
                input = new StringTokenizer(br.readLine());
                shops[i] = StringToInt(input);
            }
            long minCost = 0;
            bw.write(minCost + "\n");
        }

        br.close();
        bw.close();
    }
    
}
