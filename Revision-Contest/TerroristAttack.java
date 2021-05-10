//Enter code here
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class TerroristAttack {
    private static int update = 1;
    private static int[][] visited = new int[1000][1000];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(input.nextToken());
        while(t-- > 0){
            input = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(input.nextToken());
            int m = Integer.parseInt(input.nextToken());
            char[][] arr = new char[n][m];
            for (int i = 0; i < arr.length; i++) {
                input = new StringTokenizer(br.readLine());
                arr[i] = input.nextToken().toCharArray();
                // System.out.println(Arrays.toString(arr[i]));
            }
            int count = 1;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    visited[i][j] = 0;
                }
            }
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if(visited[i][j] == 0){
                        update = count;
                        connectedComponents(arr, i, j);
                        count++;
                    } 
                }
            }
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    // System.out.print(visited[i][j] + " ");
                    set.add(visited[i][j]);
                }
                // System.out.println();
                
            }
            System.out.println(set.size());
        }
    }

    private static void connectedComponents(char[][] arr,int row,int col){
        if(row < 0 || col < 0 || row >= arr.length || col >= arr[0].length)
            return ;
        
        if(visited[row][col] != 0)
        {
            update = visited[row][col];
            return ;
        }
        if(arr[row][col] == 'S'){
            visited[row][col] = update;
            connectedComponents(arr, row+1, col);
            if(update != visited[row][col])
                visited[row][col] = update;
        }
        if(arr[row][col] == 'N'){
            visited[row][col] = update;
            connectedComponents(arr, row-1, col);
            if(update != visited[row][col])
            visited[row][col] = update;
        }
        if(arr[row][col] == 'E'){
            visited[row][col] = update;
            connectedComponents(arr, row, col+1);
            if(update != visited[row][col])
            visited[row][col] = update;
        }
        if(arr[row][col] == 'W'){
            visited[row][col] = update;
            connectedComponents(arr, row, col-1);
            if(update != visited[row][col])
            visited[row][col] = update;
        }
    }
}
