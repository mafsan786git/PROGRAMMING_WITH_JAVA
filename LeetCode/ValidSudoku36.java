import java.util.HashSet;
import java.util.Set;

public class ValidSudoku36 {
    public static void main(String[] args) {
        char[][] board = new char[][]{
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
         };
         boolean answer = isValidSudoku(board);
    }

    public static boolean isValidSudoku(char[][] board) {
        for(int row = 0; row <9;row++){
            for(int column = 0;column < 9;column++){
                boolean valid = isValidSpace(board,row,column);
                if(!valid){
                    return false;
                }
            }
        }
        for(int row = 1;row < 9;row = row+3){
            for(int column = 1;column < 9;column = column + 3){
                if(!isValidSubBox(board, row, column)){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValidSpace(char[][] board,int row,int column){
        if(!isValidRow(board,row)) return false;
        if(!isValidColumn(board,column)) return false;
        return true; 
    }

    public static boolean isValidColumn(char[][] board,int column){
        Set<Character> numberMap = new HashSet<>();
        for(int row = 0;row < 9;row++){
            if(board[row][column] != '.'){
                if(numberMap.contains(board[row][column]))
                    return false;
                numberMap.add(board[row][column]);
            }
        }
        return true;
    }

    public static boolean isValidRow(char[][] board,int row){
        Set<Character> numberMap = new HashSet<>();
        for(int column = 0;column < 9;column++){
            if(board[row][column] != '.'){
                if(numberMap.contains(board[row][column]))
                    return false;
                numberMap.add(board[row][column]);
            }
        }
        return true;
    }

    public static boolean isValidSubBox(char[][] board,int row,int column){
        Set<Character> numberMap = new HashSet<>();
        for(int r = row-1;r <= row+1;r++){
            if(r < 0 || r >=9)
                continue;
            for(int c = column-1;c <= column+1;c++){
                if(c < 0 || c >=9)
                    continue;
                if(board[r][c] != '.'){
                    if(numberMap.contains(board[r][c]))
                        return false;
                    numberMap.add(board[r][c]);
                }
            }
        }
        return true;
    }
}
