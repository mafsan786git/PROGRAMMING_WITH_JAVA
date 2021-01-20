import java.io.*;
import java.util.*;
public class CountIsland {
    static int[] StringToInt(StringTokenizer input){
        int[] arr = new int[input.countTokens()];
        int i=0;
        while(input.hasMoreTokens())
            arr[i++] = Integer.parseInt(input.nextToken());
        return arr;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(input.nextToken());
        while(t-- > 0)
        {
            input = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(input.nextToken());
            int[][] grid = new int[n][n];
            for (int i = 0; i < grid.length; i++) {
                input = new StringTokenizer(br.readLine());
                grid[i] = StringToInt(input);
            }
            int minCost = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if(grid[i][j] == 1)
                        minCost += totalIslandCount(grid,i,j);
                }
            }
            
            bw.write(minCost + "\n");
            br.close();
            bw.close();
        }

    }

    private static int totalIslandCount(int[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i == grid.length || j == grid[0].length)
            return 1;
        if(grid[i][j] == 0)
            return 1;

        if(grid[i][j] == 1)
        {
            grid[i][j] = -1;
            totalIslandCount(grid, i+1, j);
            totalIslandCount(grid, i-1, j);
            totalIslandCount(grid, i, j+1);
            totalIslandCount(grid, i, j-1);
            
        }
        return 1;
    }
    
    
}
