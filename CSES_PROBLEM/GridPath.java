import java.io.*;
import java.util.*;
public class GridPath {
    public static void main(String[] arg) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < grid.length; j++) {
                if(line.charAt(j) == '*')
                    grid[i][j] = 0;
                else
                    grid[i][j] = -1;
            }      
        }
        if(grid[0][0] != 0){
            grid[0][0] = 1;
            for (int i = 1; i < grid.length; i++) {
                if(grid[0][i] != 0)
                    grid[0][i] = grid[0][i-1];
                if(grid[i][0] != 0)
                    grid[i][0] = grid[i-1][0];
            }
            for (int i = 1; i < grid.length; i++) {
                for (int j = 1; j < grid.length; j++) {
                    if(grid[i][j] != 0)
                        grid[i][j] = (grid[i-1][j] + grid[i][j-1])%1000000007;
                }
            }
            System.out.println(grid[n-1][n-1]);
        }
        else
        System.out.println(0);
            
        
        sc.close();
    }
}
