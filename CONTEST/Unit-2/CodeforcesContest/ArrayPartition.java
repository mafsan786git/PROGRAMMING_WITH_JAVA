import java.util.ArrayList;
import java.util.Scanner;

public class ArrayPartition {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        long[] prefix = new long[n]; 
        long[] sufix = new long[n];
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i-1] + arr[i];
        }
        sufix[n-1] = arr[n-1];
        for (int i = n-2; i >=0; i--) {
            sufix[i] = sufix[i+1] + arr[i];
        }
        long sumOfArr = prefix[n-1];
        ArrayList<Integer> validIndex = new ArrayList<>();
        for (int i = 0; i < sufix.length; i++) {
            if(sufix[i] == sumOfArr/3)
                validIndex.add(i);
        }
        long count = 0;
        if(sumOfArr%3 != 0)
            System.out.println(count);
        else{
            for (int i = 0; i < prefix.length; i++) {
                if(prefix[i] == sumOfArr/3)
                {
                    int res = binarySearch(validIndex,i+1);
                    if(res != -1)
                        count += validIndex.size()-res;
                }
            }
            System.out.println(count);
        }
        
        sc.close();
    }

    private static int binarySearch(ArrayList<Integer> validIndex, int idx) {
        int low = 0;
        int high = validIndex.size()-1;
        int ans = -1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(validIndex.get(mid) <= idx)
                low = mid+1;
            else if(validIndex.get(mid) > idx && mid == 0)
                return mid;
            else{
                high = mid-1;
                ans = mid;
            }
        }
        return ans;
    }
}
