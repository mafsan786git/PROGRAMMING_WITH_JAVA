import java.io.*;
import java.util.*;

public class Validator {
    static char[] StringToInt(StringTokenizer input){
        char[] arr = input.nextToken().toCharArray();
        return arr;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(input.nextToken());
        while(t-- > 0){
            input = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(input.nextToken());
            int m = Integer.parseInt(input.nextToken());
            char[][] maze = new char[n][m];
            for (int i = 0; i < maze.length; i++) {
                input = new StringTokenizer(br.readLine());
                maze[i] = StringToInt(input);
            }
            int count=0;
            boolean present = false;
            for (int i = 0; i < maze.length; i++) {
                for (int j = 0; j < maze[0].length; j++) {
                    if(((i == 0 || i == maze.length-1) && maze[i][j] == '.') 
                        || ((j == 0 || j == maze[0].length-1) && maze[i][j] == '.')){
                            count++;
                        if(mazePathFind(maze,i,j,i,j) && !present)
                            present = true;
                    }  
                 }
            }
            System.out.println((present && count==2) ? "yes" : "no");
        }
    }
    private static boolean mazePathFind(char[][] maze, int row, int col,int prow,int pcol) {
        if(row == maze.length || row < 0 || col < 0 || col == maze[0].length)
            return false;
        if(maze[row][col] == '#')
            return false;
        if((prow != row || pcol != col) && maze[row][col] == '.')
            return true;
        maze[row][col] = '#';
        boolean flag =  mazePathFind(maze, row, col-1,row,col) ||
                        mazePathFind(maze, row, col+1,row,col) ||
                        mazePathFind(maze, row-1, col,row,col) ||
                        mazePathFind(maze, row+1, col,row,col);
        maze[row][col] = '.';
        return flag;
    }
}
