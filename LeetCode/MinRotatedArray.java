public class MinRotatedArray {
    public static void main(String[] args) {
        int answer = minValueInRotated(new int[]{2});
        System.out.println(answer);
    }

    public static int minValueInRotated(int[] nums){
        int left = 0;
        int right = nums.length-1;
        int min = 0;
        while(left <= right){
            int mid = left + (right-left)/2;
                if(nums[nums.length-1] < nums[mid]){
                    left = mid+1;
                }else{
                    min = mid;
                    right = mid-1;
                }
        }
        return nums[min];
    }
}
