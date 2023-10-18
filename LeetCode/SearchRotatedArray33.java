public class SearchRotatedArray33 {
    public static void main(String[] args) {
        int answer = targetValueInRotated(new int[]{4,5,6,7,0,1,2},0);
        System.out.println(answer);
    }

    public static int targetValueInRotated(int[] nums,int target){
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(target == nums[mid]) return mid;
            boolean midFlag = nums[nums.length-1] < nums[mid];
            boolean targetFlag = nums[nums.length-1] < target;
            if(midFlag == targetFlag){
                if(nums[mid] < target)
                    left = mid + 1;
                else
                    right = mid - 1;
            }else{
                if(target <= nums[nums.length-1]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
