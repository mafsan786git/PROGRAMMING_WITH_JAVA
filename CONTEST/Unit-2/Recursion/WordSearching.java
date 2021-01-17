import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
Description

You are a fan of Masai School and hence you want to write a program that checks for the presence of the string "wordtosearch" in a 2d array.
There is a path from any cell of the 2d array to all its neighbouring cells.
Given 2d arrays, your task is to find if the string is present or not if all the cells in the matrix are connected to all its neighbouring cells.
input formate
7 6
l l s c s d
h b s h l m
i l h c c m
m l d a b l
a s d b c o
o o a c s o
l c d i c h
*/
public class WordSearching {
    static char[] StringToChar(StringTokenizer input) {
        char[] arr = new char[input.countTokens()];
        int i = 0;
        while (input.hasMoreTokens())
            arr[i++] = input.nextToken().charAt(0);
        return arr;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(input.nextToken());
        int m = Integer.parseInt(input.nextToken());
        char[][] matrix = new char[n][m];
        for (int i = 0; i < matrix.length; i++) {
            input = new StringTokenizer(br.readLine());
            matrix[i] = StringToChar(input);
        }
        String[] WordStr = new String[]{"oath","pea","eat","rain"};
        for(String word : WordStr)
        {
            word = "masaischool";
            boolean[][] Visited = new boolean[n][m];
            boolean present = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(matrix[i][j] == word.charAt(0))
                    {
                        if(SearchMasai(matrix,i,j,word,Visited,1))
                        {
                            present = true;
                            break;
                        }
                    }
                }
            }
            if(present)
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }
    static boolean SearchMasai(char[][] matrix,int row,int col,String masai,boolean[][] Visited,int index) {

        if(index == masai.length())
            return true;
        if(row >=matrix.length || row < 0 || col <0 || col >= matrix[0].length)
            return false;
        Visited[row][col] = true;
        //for every direction diagonaly,verticaly and horizontally.
        for (int i = -1; i <=1; i++) {
            for (int j = -1; j <=1; j++) {
                if(row+i == matrix.length || col+j == matrix[0].length || row+i < 0 || col+j < 0)
                    continue;
                if(Visited[row+i][col+j] || matrix[row + i][col+j] != masai.charAt(index))
                    continue;
                if(SearchMasai(matrix, row+i, col+j, masai, Visited, index+1))
                {
                    // System.out.println(row + " " + col);
                    return true;
                }
            }
        }
        Visited[row][col] = false;
        return false;
    
    }
/** 
    [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
    */
}
