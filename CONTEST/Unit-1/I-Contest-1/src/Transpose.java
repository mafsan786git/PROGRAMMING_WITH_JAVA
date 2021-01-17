
import java.util.Scanner;

public class Transpose {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            int n = sc.nextInt();
            int [][] mat = new int[n][n];
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++)
                    mat[i][j] = sc.nextInt();
            for(int i=0;i<n;i++)
                for (int j=0;j<n;j++)
                    if(i<j)
                    {
                        int temp = mat[i][j];
                        mat[i][j] = mat[j][i];
                        mat[j][i] = temp;
                    }
            for(int [] x: mat) {
                for (int y : x)
                    System.out.print(y + " ");
                System.out.println();
            }
            t--;
        }
    }
}
