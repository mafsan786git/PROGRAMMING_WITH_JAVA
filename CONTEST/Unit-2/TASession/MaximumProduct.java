import java.util.Scanner;

public class MaximumProduct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int prod = arr[i];
            for (int j = i+1; j < arr.length; j++) {
                max = Math.max(max, prod);
                prod *= arr[j];
            }
        }

        System.out.println(max);
        sc.close();
    }
    
}
