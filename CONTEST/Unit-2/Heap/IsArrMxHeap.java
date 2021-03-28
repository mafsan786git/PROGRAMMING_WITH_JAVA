import java.util.*;


public class IsArrMxHeap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n+1];
            for (int i = 1; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(checkMaxHeap(arr,n));
        }
        sc.close();
    }

    private static int checkMaxHeap(int[] arr, int n) {
        for (int i = 1; i < arr.length/2; i++) {
            int left = 2*i+1;
            int right = 2*i+2;
            if(arr[i] < arr[left] || arr[i] < arr[right])
                return 0;
        }
        return 1;
    }
}