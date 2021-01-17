import java.io.*;
import java.util.*;

/***
 * 
 * 
 * You are very good at playing chess since childhood and you knew the rules very much. You have a  10 X 10 chessboard and you want to explore all the possible squares on the board that the knight can be at in exactly N moves.It is placed at (i,j) coordinate initially. For a 10X10 chessboard (1,1) will be the top left corner and (10,10) will be the bottom right corner.
You can refer the following diagram, the knight can move to any of the squares marked as X in 1 move.

Image


 */

public class FollowNights {
    public static int count=0;
    static void TotalMoves(int row,int col,int n,int[][] chessBoard)
    {
        if(row < 1 || col > 10 || col < 1 || row > 10 )
            return ;
        if(n == 0 && chessBoard[row][col] == 1)
            return ;
        if(n == 0)
        {
            chessBoard[row][col] = 1;
            count++;
            return ;
        }

        TotalMoves(row+2, col-1, n-1, chessBoard);
        TotalMoves(row+2, col+1, n-1, chessBoard);
        TotalMoves(row-2, col-1, n-1, chessBoard);
        TotalMoves(row-2, col+1, n-1, chessBoard);

        TotalMoves(row-1, col+2, n-1, chessBoard);
        TotalMoves(row+1, col+2, n-1, chessBoard);
        TotalMoves(row-1, col-2, n-1, chessBoard);
        TotalMoves(row+1, col-2, n-1, chessBoard);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int i = Integer.parseInt(input.nextToken());
        int j = Integer.parseInt(input.nextToken());
        int n = Integer.parseInt(input.nextToken());
        int[][] chessBoard = new int[11][11];
        TotalMoves(i,j,n,chessBoard);
        System.out.println(count);
    }
    
}
