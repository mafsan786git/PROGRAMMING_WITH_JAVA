import java.io.*;
import java.util.*;
/**
    Alice is in a shopping mall to buy books, shirts and shoes. The mall has exactly N different shops and each shop contains all these three items at different prices. Alice has a plan which she will be following. As per her plan, she won't buy the same item from the current shop if she had already bought that item from the shop adjacent to the current shop.
    Alice wants to follow her strategy strictly but at the same time she wants to minimize the total money she spends on shopping. You are provided description about all N shops i.e costs of all three items in each shop. You need to help Alice find minimum money that she needs to spend such that she buys exactly one item from every shop.
    
    For each test case, output the minimum cost of shopping taking the mentioned conditions into account in a separate line.

Sample Input 1 

1
3
1 50 50
50 50 50
1 50 50
Sample Output 1
52

 */
public class ShopingDp {
    static int[] StringToInt(StringTokenizer input) {
        int[] arr = new int[input.countTokens()];
        int i = 0;
        while (input.hasMoreTokens())
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
            long minCost = minCostCalculation(shops);
            bw.write(minCost + "\n");
        }

        br.close();
        bw.close();
    }

    private static long minCostCalculation(int[][] shops) {
        long[][] dp = new long[shops.length][3];
        dp[0][0] = shops[0][0];
        dp[0][1] = shops[0][1];
        dp[0][2] = shops[0][2];
        
        for (int i = 1; i < dp.length; i++) {
            long x=0,y=0;
            for (int j = 0; j < 3; j++) {
                if(j == 0){
                    x = shops[i][j] + dp[i-1][1];
                    y = shops[i][j] + dp[i-1][2];
                }else if(j == 1){
                    x = shops[i][j] + dp[i-1][0];
                    y = shops[i][j] + dp[i-1][2];
                }if(j == 2){
                    x = shops[i][j] + dp[i-1][1];
                    y = shops[i][j] + dp[i-1][0];
                }
                dp[i][j] = Math.min(x, y);
            }
        }
        long minCost = Long.MAX_VALUE;
        for (int i = 0; i < dp[0].length; i++) {
            minCost = Long.min(minCost, dp[dp.length-1][i]);
        }
        return minCost;
    }

    public static int minFind(int[] itemCost,HashSet<Integer> setIndex)
    {
        int min = 0;
        if(!setIndex.contains(0))
            min = 1;
        for(Integer index : setIndex)
            if(itemCost[index]< itemCost[min])
                min = index;
        return min;
    }
}
