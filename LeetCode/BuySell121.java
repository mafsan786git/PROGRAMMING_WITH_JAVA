public class BuySell121 {
    public static void main(String[] args) {
        int[] price = new int[]{7,1,5,3,6,4};
        int answer = maxProfit(price);
        System.out.println(answer);
    }

    public static int maxProfit(int[] prices) {
        int minIndex = 0;
        int maxValue = 0;
        for(int i = 1;i < prices.length; i++){
            maxValue = Math.max(maxValue,prices[i]-prices[minIndex]);
            if(prices[i] < prices[minIndex]){
                minIndex = i;
            }
        }
        return maxValue;
    }
}