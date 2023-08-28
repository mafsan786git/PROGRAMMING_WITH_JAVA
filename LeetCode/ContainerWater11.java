public class ContainerWater11 {
    public static void main(String[] args) {

        int[] heights = new int[]{1,8,6,2,5,4,8,3,7};
        int left = 0;
        int right = heights.length-1;
        int answer = 0;
        while(left < right){
            int height = heights[right];
            int length = right-left;
            if(heights[left] < heights[right]){
                height = heights[left];
                left++;
            }else{
                right--;
            }
            answer = Math.max(answer, height *length);
        }
        System.out.println(answer);
    }
}
