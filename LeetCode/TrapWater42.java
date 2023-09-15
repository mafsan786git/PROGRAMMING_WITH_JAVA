public class TrapWater42 {
    public static void main(String[] args) {
        int answer = trapWithSpace(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
        System.out.println(answer);
    }

    public static int trapWithSpace(int[] height) {
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        maxLeft[0] = 0;
        maxRight[height.length-1] = 0;
        int total = 0;
        for(int i=1;i < height.length;i++){
            maxLeft[i] = Math.max(height[i-1],maxLeft[i-1]);
        }
        for(int i=height.length-2;i >=0;i--){
            maxRight[i] = Math.max(height[i+1],maxRight[i+1]);
        }
        for(int i=0;i < height.length;i++){
            int value = Math.min(maxLeft[i], maxRight[i]) - height[i];
            if(value > 0){
                total += value;
            }
        }
        return total;
    }
}
