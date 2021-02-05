import java.io.*;
import java.util.*;
public class ReturnToOrigin {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        // BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
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
        if(dfsMaze(matrix, x-1, y-1, k, 0,x-1,y-1))
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    private static boolean dfsMaze(char[][] matrix, int curx, int cury, int k, int count,int x,int y) {
        if(count >= k && (x == curx && cury == y))
            return true;
        if(count >= k)
            return false;
        if(curx == matrix.length || curx == matrix[0].length || curx < 0 || cury < 0)
            return false;
        // matrix[curx][cury] = '*';
        boolean flag = false;
        for (int i = -1; i <=1; i++) {
            for (int j = -1; j <= 1; j++) {
                if((i == -1 && j == -1) || (i == 1 && j == 1) || (curx+i+cury+j == curx+cury)) continue;
                if(curx+i == matrix.length || cury+j == matrix[0].length || curx +i < 0 || cury+j < 0) continue;
                if(matrix[curx+i][cury+j] == '*' || (i == 0 && j==0)) continue;
                matrix[curx+i][cury+j] = '*';
                flag = dfsMaze(matrix, curx+i, cury+j, k, count+1, x, y);
                matrix[curx+i][cury+j] = '.';
            }
        }
        // matrix[curx][cury] = '.' ; 
        return flag;
    }
    
}
