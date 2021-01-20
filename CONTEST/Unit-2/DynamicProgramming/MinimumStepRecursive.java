import java.util.Scanner;

public class MinimumStepRecursive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(minStepRecur(arr,n,0));
        sc.close();
    }

    private static int minStepRecur(int[] arr, int n, int index) {
        if(index >= n-1)
            return 0;

        int minStep = n;
        for (int i = arr[index]; i > 0 ; i--) {
            minStep = Math.min(minStep,1 + minStepRecur(arr, n, index + i));
        }
        // System.out.println(minStep);
        return minStep;
    }
    
}
