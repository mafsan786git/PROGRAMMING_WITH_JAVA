import java.util.Scanner;

public class LevelOfHeap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }
            arr[0] = 0;
            for (int i = 0; i <= arr.length/2; i++) {
                int left = 2*i+1;
                int right = 2*i + 2;
                if(left < n)
                    arr[left] = arr[i]+1;
                if(right < n)
                    arr[right] = arr[i]+1;
            }
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
