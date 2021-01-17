import java.io.*;
import java.util.*;
/**
 * Description
    The floor of 91 springboard is covered by h × w square tiles, where there are h rows of tiles from front (first row) to back (last row) and w columns of tiles from left to right. Each tile has value of 1 to 100 written on it.
    You have to walk on tiles such that sum of numbers is as high as possible, subject to the following restrictions:
    You start by choosing any tile in the first row, and collects the value on that tile. Then, you move to a tile in the next row, collects the value on the tile, and so on until you reach the last row.
    When you move from one tile to a tile in the next row, you can only move to the tile just below it or diagonally to the left or right.
    Given the values of h and w, and the value on each tile, write a program to compute the maximum possible sum you can grab in one single trip from the first row to the last row.
Input
    Input Format :
        The first line consists of a single integer T, the number of test cases.
        In each of the test cases, the first line has two integers. The first integer h is the number of rows of tiles on the floor. The second integer w is the number of columns of tiles on the floor.
        Next, there are h lines of inputs. The i-th line of these, specifies the value in each tile of the i-th row from the front. Each line has w integers, where each integer m (0 <= m <= 100) is the number on that tile. The integers are separated by a space character.
    Constraints:
        1 <= T <= 100
        1 <= w <= 100
        1 <= h <= 100
Output
    The output should consist of T lines, one for each test case. Each line consists of a single integer, which is the maximum possible sum you can grab, in one single trip from the first row to the last row for the corresponding test case.
Sample Input 1 
1
6 5
3 1 7 4 2
2 1 3 1 1
1 2 2 1 8
2 2 1 5 3
2 1 4 4 4
5 2 7 5 1
Sample Output 1
32

 */
public class SpringBoardDp {
    static int[] StringToInt(StringTokenizer input){
        int[] arr = new int[input.countTokens()];
        int i=0;
        while(input.hasMoreTokens())
            arr[i++] = Integer.parseInt(input.nextToken());
        return arr;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(input.nextToken());
        while(t-- > 0){
            input  = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(input.nextToken());
            int m = Integer.parseInt(input.nextToken());
            int[][] board = new int[n][m];
            for (int i = 0; i < board.length; i++) {
                input = new StringTokenizer(br.readLine());
                board[i] = StringToInt(input);
            }
            int maxSum = 0;
            int[][] visited = new int[n][m];
            for (int i = 0; i < board[0].length; i++) {
                 maxSum = Math.max(maxSum,maxTripSum(board,0,i,0,visited));
            }
            System.out.println(maxSum);
            
        }
    }

    private static int maxTripSum(int[][] board, int row, int col, int sum,int[][] visited) {
        if(col < 0 || col == board[0].length)
            return 0;
        if(row == board.length)
            return 0;
        if(visited[row][col] != 0)
            return visited[row][col];
        
        int temp1 = board[row][col] + maxTripSum(board, row+1, col-1, sum, visited);
        int temp2 = board[row][col] + maxTripSum(board, row+1, col, sum, visited);
        int temp3 = board[row][col] + maxTripSum(board, row+1, col+1, sum, visited);
        temp2 = Math.max(temp2, temp1);
        visited[row][col] = Math.max(temp2,temp3);
        return visited[row][col];
    }
    
}
