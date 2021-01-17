import java.util.Arrays;
import java.util.Scanner;

public class DiagonalSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(0 < t--){
            int n = sc.nextInt();
            int[] arr = new int[n*n];
            for (int i = 0; i < n*n; i++) {
                arr[i] = sc.nextInt();
            }
            int[][] mat = new int[n][n];
            int R = n-1,r= 0;
            int C = n-1,c = 0;int d =0;
            int index=0;
            while( R >=0 && C>=0) {
                if (d == 0) {
                    for (int j = c; j <= C; j++) {
                        mat[r][j] = arr[index++];
                    }
                    d++;
                    r++;

                }
                if (d == 1) {
                    for (int i = r; i <= R; i++) {
                        mat[i][C] = arr[index++];
                    }
                    d++;
                    C--;
                }
                if (d == 2) {
                    for (int j = C; j >= c; j--) {
                        mat[R][j] = arr[index++];
                    }
                    d++;
                    R--;
                }
                if (d == 3) {
                    for (int i = R; i >= r; i--) {
                        mat[i][c] = arr[index++];
                    }
                    d = 0;
                    c++;
                }
            }
//            for(int[] x : mat){
////                for(int val : x)
//                    System.out.println(Arrays.toString(x) + " ");
//            }

            long sum = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(i == j || (i+j+1) == n) {
//                        System.out.print(arr[k] + " ");
                        sum += mat[i][j];
                    }
                }
//                System.out.println();
            }
            System.out.println(sum);

        }
    }
}
