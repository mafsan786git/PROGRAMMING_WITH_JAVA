import java.io.*;
import java.util.*;
/**
 * You are given a starting point (row, column) where you are present in the maze. your task is to find out whether or not you can traverse the maze and return to the original position. You cannot visit any cell in the maze that has already been visited. Also, you have to make a minimum of 'k' number of moves before returning to the starting point. The '.' represent the empty blocks whereas the '*' represent the blocks that can't be visited .From a block (x,y) you can move only to blocks (x-1,y) , (x+1,y) , (x,y+1) , (x,y-1) . You have to print if it is possible return to your original position.
Input
The first line of the input contains the dimensions of the maze ( N x M). Second line of the input contains 'k' as described in problem .The third line denotes the coordinates of the starting point. The next N lines contain the description of the N rows
Constraints
1 <= N, M <= 100
Output
Output "YES" (without quotes) if it's possible .
Else output "NO" (without quotes.
 */
public class ReturnToOrigin {
    private static int[] dir_x = new int[]{1,0,-1,0};
    private static int[] dir_y = new int[]{0,1,0,-1};
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        // BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(input.nextToken());
        int m = Integer.parseInt(input.nextToken());
        input = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(input.nextToken());
        input = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(input.nextToken());
        int y = Integer.parseInt(input.nextToken());
        char[][] matrix = new char[n][m];
        for (int i = 0; i < matrix.length; i++) {
            input = new StringTokenizer(br.readLine());
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = input.nextToken().charAt(0);
            }
        }
        if(dfsMaze(matrix, x-1, y-1, k,x-1,y-1))
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    private static boolean dfsMaze(char[][] matrix, int curx, int cury, int k,int x,int y) {
        if(k <= 0 && (x == curx && cury == y))
            return true;
        if(curx == matrix.length || cury == matrix[0].length || curx < 0 || cury < 0 || matrix[curx][cury] == '*')
            return false;
        matrix[curx][cury] = '*';
        for (int i = 0; i < 4; i++) {
            if(dfsMaze(matrix, curx+dir_x[i], cury + dir_y[i], k-1, x, y))
                return true;
        }
        matrix[curx][cury] = '.' ; 
        return false;
    }
    
}
