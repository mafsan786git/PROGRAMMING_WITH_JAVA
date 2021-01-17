import java.util.HashSet;
import java.util.Scanner;

public class RowDistinct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(0 < t--){
            int n =  sc.nextInt();
            int m = sc.nextInt();
            int[][] mat = new int[n][m];
            for(int i=0;i<n;i++)
                for (int j = 0; j < m; j++) {
                    mat[i][j] = sc.nextInt();
                }
            int[] map = new int[101];
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                set.clear();
                for (int j = 0; j < m; j++) {
                    if(!set.contains(mat[i][j]))
                    {
                        set.add(mat[i][j]);
                        map[mat[i][j]]++;
                    }
                }
            }
            int count=0;
            for (int i = 0; i < 101; i++) {
                if(map[i] == n)
                    count++;
            }
            System.out.println(count);
        }
    }
}
