import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AgainOptimizationRecur {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(input.nextToken());
        while(t-- > 0){
            input = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(input.nextToken());
            int n = Integer.parseInt(input.nextToken());
            int[] artifact = new int[n];
            int[] values = new int[n];
            for (int i = 0; i < values.length; i++) {
                input = new StringTokenizer(br.readLine());
                artifact[i] = Integer.parseInt(input.nextToken());
                values[i] = Integer.parseInt(input.nextToken());
            }
            System.out.println(maxValueRecur(artifact,values,S,0));
        }
    }

    private static int maxValueRecur(int[] artifact,int[] values,int capacity,int index){
        if(capacity <= 0 || index == values.length)
            return 0;
        int totalProfit  = 0;
        if(artifact[index] <= capacity)
            totalProfit = values[index] + maxValueRecur(artifact, values, capacity-artifact[index], index+1);
        
        int profit = maxValueRecur(artifact, values, capacity, index+1);
        return Math.max(profit, totalProfit);

    }
    
}
