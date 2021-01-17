import java.io.*;
import java.util.*;

/**
 * 
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
    Given an integer n, print the number of distinct solutions to the n-queens puzzle.

 */
public class NQueen {
    static void ResetBoard(List<String> board,int n)
    {
        for (int i = 0; i < n; i++) {
            StringBuilder str = new StringBuilder("");
            for (int j = 0; j < n; j++) {
                str.append(".");
            }
            board.add(str.toString());
            
        }
    }
    static int count = 0;
    static List<List<String>> output = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> board = new ArrayList<>();
        ResetBoard(board,n);
        output.clear();
        for (int i = 0; i < board.size(); i++) {
            StringBuilder str = new StringBuilder(board.get(0));
            str.setCharAt(i, 'Q');
            board.set(0, str.toString());
            PlaceQueen(board, board.size()-1, 1);
            // ResetBoard(board,n);
            str.setCharAt(i, '.');
            board.set(0, str.toString());
        }
        System.out.println(count);
        System.out.println(output);
        sc.close();
    }
    static boolean CheckSpace(List<String> board,int row,int col)
    {
        for (int i = 0; i < board.size(); i++) {
            if(board.get(row).charAt(i) == 'Q') return true;
        }
        for (int i = 0; i < board.size(); i++) {
            if(board.get(i).charAt(col) == 'Q') return true;
        }
        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board.size(); j++) {
                if((i+j) == (row+col) && board.get(i).charAt(j) == 'Q') return true;
                if((i-j) == (row-col) &&board.get(i).charAt(j) == 'Q') return true;
            }
        }
        return false;
    }
    static void PlaceQueen(List<String> board,int n,int row){
        if(n == 0){
            count++;
            output.add(new ArrayList<>(board));
            // System.out.println(board);
            return ;
        }
        for (int i = row; i < board.size();i++) {
            for (int j = 0; j < board.size(); j++) {
                if(CheckSpace(board, i, j)) continue;
                StringBuilder str = new StringBuilder(board.get(i));
                str.setCharAt(j, 'Q');
                board.set(i, str.toString());
                PlaceQueen(board, n-1, i+1);
                str.setCharAt(j, '.');
                board.set(i, str.toString());
            }
        }
        return ;
    }

}
