import java.util.*;

public class BalancedBT108 {
    public static void main(String[] args){
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7 };
        ListNode root = createBalancedBT(nums,0,nums.length-1);
        List<Integer> answer = new ArrayList<>();
        TreeTraversal94.preOrderTraversal(root, answer);
        System.out.println(answer);
    }

    private static ListNode createBalancedBT(int[] nums,int start,int end){
        if(start > end){
            return null;
        }
        int mid = start + (end-start)/2;
        ListNode root = new ListNode(nums[mid]);
        root.left = createBalancedBT(nums, start, mid-1);
        root.right = createBalancedBT(nums, mid+1, end);
        return root;
    }
}
