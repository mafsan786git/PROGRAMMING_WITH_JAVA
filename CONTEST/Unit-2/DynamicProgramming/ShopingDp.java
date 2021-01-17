import java.io.*;
import java.util.*;

public class ShopingDp {
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
            long minCost = minCostCalculation(shops);
            System.out.println(minCost);

        }
    }

    private static long minCostCalculation(int[][] shops) {
        int[][] dp = new int[shops.length][3];
        dp[0][0] = 0;dp[0][1] = 1;dp[0][2] = 2;
        
        for (int i = 1; i < dp.length; i++) {
            HashSet<Integer> setIndex = new HashSet<>(Arrays.asList(0,1,2));
            for (int j = 0; j < dp[0].length; j++) {
                setIndex.remove(dp[i-1][j]);
                int index1 = minFind(shops[i], setIndex);
                if(i != shops.length-1)
                {
                    int index2 = minFind(shops[i+1], setIndex);
                    if(index2 == index1)
                    {
                        int[] sum = new int[2];
                        int idx = 0;
                        for (int k = 0; k < 3; k++) {
                            if(k != index1){
                                sum[idx++] = shops[i][index1] + shops[i+1][k];
                            }
                        }
                        int sumTemp = 0;
                        for(Integer id : setIndex)
                        {
                            if(index1 != id){
                                sumTemp = shops[i][id] + shops[i+1][index1];
                                index2 = id;
                            }
                        }
                        if(sum[0] > sumTemp && sum[1] > sumTemp)
                            index1 = index2;
                    }
                }
                dp[i][j] = index1;
            }
        }
        long minCost = Long.MAX_VALUE;
        for (int i = 0; i < dp[0].length; i++) {
            long costSum = 0;
            for (int j = 0; j < dp.length; j++) {
                costSum += shops[j][dp[j][i]];
            }
            minCost = Long.min(minCost, costSum);
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
