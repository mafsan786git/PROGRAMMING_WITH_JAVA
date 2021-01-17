import java.util.ArrayList;
import java.util.List;

public class LongestIncreSubRec {
    public static void main(String[] args) {
        int[] height = new int[]{2,0,3,1,4,2,3};
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        System.out.println(recursiveLIS(height, 0, list));
    }
    static int max = 0;
    private static int recursiveLIS(int[] height, int index,List<Integer> list) {
        if(index == height.length)
        {
            System.out.println(list);
            return 0;
        }
        int exclude = recursiveLIS(height, index+1, list);
        
        int include = 0;
        if(height[index] > list.get(list.size()-1)){
            list.add(height[index]);
            include = 1 + recursiveLIS(height, index+1, list);
            list.remove(list.size()-1);
        }
        return Math.max(include, exclude);

    }
}
