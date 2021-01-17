import java.util.Arrays;
import java.util.Scanner;

public class ClosetTraget {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(0 < t--){
            int n = sc.nextInt();
            int target = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
//            System.out.println(Arrays.toString(arr));
            int nearest = 0;
            for (int i = 0; i < n-1; i++) {
                for (int j = i+1,k=n-1; j < k;) {
                    int sum = arr[i] + arr[j] + arr[k];
                    if(Math.abs(target-sum) < Math.abs(target-nearest))
                    {
//                        System.out.println(i + " " + j + " " + " " + k + (sum));
                        nearest = sum;

                    }else if(Math.abs(target-sum) == Math.abs(target-nearest))
                        nearest = Math.max(nearest ,sum);
                    if(sum > target)
                        k--;
                    else
                        j++;
                }
            }
            System.out.println(nearest);
        }
    }
}

