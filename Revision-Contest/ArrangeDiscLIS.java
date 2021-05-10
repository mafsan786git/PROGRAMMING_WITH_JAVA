import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
/**One day Virat challenges Rohit to build the tallest tower from a set of disks of different height and radius. The tower can be built by stacking disks on top of each other. In order to put disk A on top of disk B, the radius and height of A must be strictly smaller than those of B.
 */
public class ArrangeDiscLIS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[][] arr = new int[n][2];
            for (int i = 0; i < arr.length; i++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }
            Arrays.sort(arr,new Comparator<int[]>(){
                public int compare(int[] a,int[] b){
                    return a[0]-b[0];
                }   
            });
            // for (int i = 0; i < arr.length; i++) {
            //     System.out.println(Arrays.toString(arr[i]));
            // }
            long[] dp = new long[n];
            for (int i = 0; i < dp.length; i++) {
                dp[i] = arr[i][1];
            }

            for (int i = 1; i < dp.length; i++) {
                for (int j = 0; j < i; j++) {
                    if(arr[j][1] < arr[i][1] && arr[j][0] < arr[i][0])
                        dp[i] = Math.max(dp[i], arr[i][1]+dp[j]);
                }
            }
            long mxSum = 0; 
            for (int i = 0; i < dp.length; i++) {
                mxSum = Math.max(mxSum, dp[i]);
                // System.out.print(dp[i] + " ");
            }
            System.out.println(mxSum);
        }
        sc.close();
    }
}
