import java.io.*;

public class LongestSubArray{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int t = Integer.parseInt(s[0]);
        while(0 < t--){
            s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            s = br.readLine().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            int count = 1,longest=1;
            //TIME complexity is O(n^2)
            // for (int i = 0; i < arr.length-1; i++) {
            //     count = 1;
            //     for (int j = i+1; j < arr.length; j++) {
            //         if(arr[j-1] < arr[j])
            //             count++;
            //         else
            //             break;
            //     }
            //     longest = Math.max(count, longest);
            // }

            //TIME complexity is O(n)
            for (int i = 1; i < arr.length; i++) {
                if(arr[i] > arr[i-1])
                    count++;
                else{
                    longest = Math.max(longest, count);
                    count=1;
                }
            }
            longest = Math.max(longest,count);
            System.out.println(longest);
        }

    }
}