import java.util.Scanner;

public class SpiralMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] mat = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                mat[i][j] = sc.nextInt();
        int R = n-1,r= 0;
        int C = n-1,c = 0;int d =0;
        while( R >=0 && C>=0)
        {
            if (d == 0)
            {
                for (int j = c; j <= C; j++) {
                    System.out.print(mat[r][j]+ " ");
                }
                d++;
                r++;

            }
            if(d == 1){
                for (int i = r; i <=R ; i++) {
                    System.out.print(mat[i][C]+ " ");
                }
                d++;
                C--;
            }
            if(d == 2){
                for (int j = C; j>=c; j--) {
                    System.out.print(mat[R][j]+ " ");
                }
                d++;
                R--;
            }
            if(d==3){
                for (int i = R; i >=r ; i--) {
                    System.out.print(mat[i][c]+ " ");
                }
                d = 0;
                c++;
            }
        }
    }
}
