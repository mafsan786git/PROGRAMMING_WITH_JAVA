import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sudoku {
    static int[] StringToInt(StringTokenizer input){
        int[] arr = new int[input.countTokens()];
        int i=0;
        while(input.hasMoreTokens())
            arr[i++] = Integer.parseInt(input.nextToken());
        return arr;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input;
        int[][] sudokuBoard = new int[9][9];
        int i = 0;
        while(i < 9)
        {
            input = new StringTokenizer(br.readLine());
            sudokuBoard[i++] = StringToInt(input);
            
        }
        if(SolveSudoku(sudokuBoard)){
            for (int j = 0; j < sudokuBoard.length; j++) {
                for (int j2 = 0; j2 < sudokuBoard.length; j2++) {
                    System.out.print(sudokuBoard[j][j2] + " ");
                }
                System.out.println();
            }
        }else
            System.out.println(-1);

    }
    
    private static boolean SearchSpace(int[][] sudokuBoard,int[] loc)
    {
        for (int i = 0; i < sudokuBoard.length; i++) {
            for (int j = 0; j < sudokuBoard.length; j++) {
                if(sudokuBoard[i][j] == 0)
                {
                    loc[0] = i;
                    loc[1] = j;
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean SolveSudoku(int[][] sudokuBoard)
    {
        int[] loc = new int[2];
        if(!SearchSpace(sudokuBoard, loc))
            return true;
        int row = loc[0],col = loc[1];
        for (int j2 = 1; j2 <= 9; j2++) {
            if(SearchMatch(sudokuBoard,row,col,j2)) continue;
            sudokuBoard[row][col] = j2;
            if(SolveSudoku(sudokuBoard)) return true;
            sudokuBoard[row][col] = 0;
        }
        return false;
    }

    private static boolean SearchMatch(int[][] sudokuBoard, int row, int col,int num) {
        for (int i = 0; i < sudokuBoard.length; i++) {
            if(sudokuBoard[row][i] == num) return true;
        }
        for (int i = 0; i < sudokuBoard.length; i++) {
            if(sudokuBoard[i][col] == num) return true;
        }
        int r = (row/3) * 3;
        int c = (col/3) * 3;
        for (int i = r; i < r+3; i++) {
            for (int j = c; j < c+3; j++) {
                if(sudokuBoard[i][j] == num) return true;
            }
        }

        return false;
    }
    
}
