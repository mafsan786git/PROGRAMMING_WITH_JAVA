
import java.util.ArrayList;
import java.util.List;

public class MatrixSpiral {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
            {1,2,3}
        };
        List<Integer> ans = spiralOrder(arr);
        System.out.println(ans);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int firstRow = 0,lastRow = matrix.length;
        int firstCol = 0,lastCol = matrix[0].length;
        //direction 0 = right, 1 = down, 2 = left, 3 = up
        int direction = 0;
        int row = 0,col = 0;
        while((row < lastRow && row >= firstRow) && (col >= firstCol && col < lastCol)){
            if(firstRow < 0 || lastRow > matrix.length) break;
            if(firstCol < 0 || lastCol > matrix[0].length) break;
            switch (direction) {
                case 0:
                    //RIGHT
                    while(col < lastCol){
                        ans.add(matrix[row][col]);
                        col++;
                    }   direction = 1;
                    col--;
                    firstRow++;
                    row = firstRow;
                    break;
                case 1:
                    //DOWN
                    while(row < lastRow){
                        ans.add(matrix[row][col]);
                        row++;
                    }   direction = 2;
                    row--;
                    lastCol--;
                    col = lastCol-1;
                    break;
                case 2:
                    //LEFT
                    while(col >= firstCol){
                        ans.add(matrix[row][col]);
                        col--;
                    }   direction = 3;
                    col++;
                    lastRow--;
                    row = lastRow-1;
                    break;
                case 3:
                    //UP
                    while(row >= firstRow){
                        ans.add(matrix[row][col]);
                        row--;
                    }   direction = 0;
                    row++;
                    firstCol++;
                    col = firstCol;
                    break;
                default:
                    break;
            }
        }
        return ans;
    }
}