import java.util.*;

public class Pascal2 {
    static int count = 0;
    static int entryCount = 0;
    public static void main(String[] args){
        System.out.println(getRow(33));
        System.out.println(entryCount + " ---- " + count);
        List<Integer> prev = new ArrayList<>(){{
            add(1);
            add(2);
        }};
        System.out.println(prev);
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        int[][] memo = new int[rowIndex+1][rowIndex+1];
        for(int index = 0;index <= rowIndex;index++){
            ans.add(getRowElement(rowIndex,index,memo));
        }
        return ans;
    }
    
    private static Integer getRowElement(int row,int col,int[][] memo){
        entryCount++;
        if(row == col) return 1;
        if(col <= 0) return 1;
        if(memo[row][col] != 0) return memo[row][col];
        count++;
        memo[row][col] = getRowElement(row-1,col-1,memo) + getRowElement(row-1,col,memo);
        return memo[row][col];
    }
}