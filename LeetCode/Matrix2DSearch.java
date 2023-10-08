public class Matrix2DSearch {

    public static void main(String[] args) {
        
    }

    private static boolean searchMatrix1(int[][] matrix,int target){
        int rowStart = 0;
        int rowEnd = matrix.length-1;
        while(rowStart <= rowEnd){
            int rowMid = rowStart + (rowEnd-rowStart)/2;
            int colStart = 0;
            int colEnd = matrix[0].length-1;
            int midCol = 0;
            while(colStart <= colEnd){
                midCol = colStart + (colEnd-colStart)/2;
                if(matrix[rowMid][midCol] == target) return true;
                if(matrix[rowMid][midCol] < target) colStart = midCol+1;
                else colEnd = midCol-1;
            }
            if(matrix[rowMid][midCol] < target) rowStart = rowMid+1;
            else rowEnd = rowMid-1;
        }
        return false;
    }

    //CODE-2
    private static boolean searchMatrix2(int[][] matrix,int target){
        int rowStart = 0;
        int rowEnd = matrix.length-1;
        while(rowStart <= rowEnd){
            int rowMid = rowStart + (rowEnd-rowStart)/2;
            if(matrix[rowMid][matrix[0].length-1] < target) rowStart = rowMid+1;
            else if(matrix[rowMid][0] > target)rowEnd = rowMid-1;
            else break;
        }
        if(rowEnd < rowStart) return false;
        int rowMid = rowStart + (rowEnd-rowStart)/2;
        int colStart = 0;
        int colEnd = matrix[0].length-1;
        while(colStart <= colEnd){
                int midCol = colStart + (colEnd-colStart)/2;
                if(matrix[rowMid][midCol] == target) return true;
                if(matrix[rowMid][midCol] < target) colStart = midCol+1;
                else colEnd = midCol-1;
        }
        return false;
    }

    //CODE-3
    private static boolean searchMatrix3(int[][] matrix,int target){
        int rowStart = 0;
        int colEnd = matrix[0].length-1;
        while(rowStart < matrix.length && colEnd >=0){
                if(matrix[rowStart][colEnd] == target) return true;
                if(matrix[rowStart][colEnd] < target) rowStart = rowStart+1;
                else colEnd = colEnd-1;
        }
        return false;
    }
}
