import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ShopingRecur {
    static int[] StringToInt(StringTokenizer input) {
        int[] arr = new int[input.countTokens()];
        int i = 0;
        while (input.hasMoreTokens())
            arr[i++] = Integer.parseInt(input.nextToken());
        return arr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
            minCostCalculation(shops,0,0,-1,0);
            System.out.println(minCost);

        }
    }
    static long minCost = Long.MAX_VALUE;
    private static void minCostCalculation(int[][] shops, int row,int col, int prevIndex,long totalCost) {
        if(row == shops.length)
        {
            minCost = Math.min(minCost, totalCost);
            System.out.println("--------------:  " + minCost);
            return ;
        }
        if(col == shops[0].length)
            return ;

        if(col != prevIndex){
            System.out.print(shops[row][col] + " ");
            minCostCalculation(shops, row+1,0,col,totalCost + shops[row][col]);
        }
        minCostCalculation(shops, row, col+1, prevIndex, totalCost);
    }
    
}
