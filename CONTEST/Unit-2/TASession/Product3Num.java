import java.io.*;
import java.util.*;

public class Product3Num{
    static int[] StringToInt(StringTokenizer input){
        int[] arr = new int[input.countTokens()];
        int i=0;
        while(input.hasMoreTokens())
            arr[i++] = Integer.parseInt(input.nextToken());
        return arr;
    }
    
    static int maximumProduct(int[] nums) {
        int len = nums.length;
        int ans = Integer.MIN_VALUE;
        if(len == 3)
            return nums[0]*nums[1]*nums[2];
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int temp = nums[0]*nums[1]*nums[2];
        ans = Math.max(ans, temp);
        temp = nums[len-1]*nums[len-2]*nums[len-3];
        ans = Math.max(ans, temp);
        temp = nums[0]*nums[1]*nums[len-1];
        ans = Math.max(ans, temp);
        // if(nums[0] >= 0)
        // {
        //     return nums[len-1]*nums[len-2]*nums[len-3];
        // }else{
        //     int i=0,j = len-1;
        //     while(i < j){
        //         if(Math.abs(nums[i]) > nums[j])
        //         {
        //             i++;
        //             if(i == 2)
        //                 break;
        //         }else{
        //             j--;
        //             if(len-1-j == 3)
        //                 break;
        //         }
        //     }if(nums[len-1] < 0)
        //     {
        //         ans = nums[len-1]*nums[len-2]*nums[len-3];
        //         System.out.println(nums[len-1] + " " + nums[len-2] + " " + nums[len-3]);
        //     }
        //     else if(i == 2)
        //     {
        //         ans = nums[0] * nums[1] * nums[len-1];
        //         System.out.println(nums[0] + " " + nums[1] + " " + nums[len-1]);
        //     }else{
        //         ans = nums[len-1]*nums[len-2]*nums[len-3];
        //         System.out.println(nums[len-1] + " " + nums[len-2] + " " + nums[len-3]);
        //     }
        // }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(input.nextToken());
        input = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        arr = StringToInt(input);
        System.out.println(maximumProduct(arr));
        
    }

    
}