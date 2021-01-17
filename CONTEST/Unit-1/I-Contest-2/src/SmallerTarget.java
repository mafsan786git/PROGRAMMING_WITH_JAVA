
import java.util.Arrays;
import java.util.Scanner;

public class SmallerTarget {
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
            int count=0;
            Arrays.sort(arr);
            System.out.println(Arrays.toString(arr));
//            for (int i = 0; i < n-1; i++) {
//                int temp = target - arr[i];
//                for (int j = i+1; j < n; j++) {
//                    int x = temp - arr[j];
//                    if((j-i)>=2 && x > arr[i+1])
//                    {
//                        System.out.println(i + " " + j + " " + arr[i+1]);
//                        count++;
//                    }
//                }
//            }
            for (int i = 0; i < n-1; i++) {
                for (int j = i+1,k=n-1; j < k;) {
                    if(arr[i] + arr[j] + arr[k] < target)
                    {
                        System.out.println(i + " " + j + " " + " " + k + (arr[i] + arr[j] + arr[k]));
                        count += (k-j);
                        j++;
                    }else
                        k--;
                }
            }
            System.out.println(count);
        }
    }
}
