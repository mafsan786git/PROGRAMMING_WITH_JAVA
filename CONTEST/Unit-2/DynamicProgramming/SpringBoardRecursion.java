import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SpringBoardRecursion {
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
            for (int i = 0; i < board[0].length; i++) {
                 maxSum = Math.max(maxSum,maxTripSum(board,0,i,0));
            }
            System.out.println(maxSum);
            
        }
    }

    private static int maxTripSum(int[][] board,int row,int col,int sum)
    {
        if(row == board.length)
        {
            return sum;
        }

        if(col < 0 || col == board[0].length)
            return 0;

        int temp1 = maxTripSum(board, row+1, col-1, sum+board[row][col]);
        int temp2 = maxTripSum(board, row+1, col, sum+board[row][col]);
        int temp3 = maxTripSum(board, row+1, col+1, sum+board[row][col]);
        temp1 = Math.max(temp1, temp2);
        temp1 = Math.max(temp1, temp3);
        // temp1 = Math.max(temp1, temp3);
        return temp1;
    }
    
}
