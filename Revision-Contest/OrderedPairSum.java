
import java.util.LinkedHashMap;
import java.util.Scanner;

public class OrderedPairSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t  = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }
            LinkedHashMap<Integer,Integer[]> set = new LinkedHashMap<>();

            for (int i = 0; i < arr.length; i++) {
                int temp = k - arr[i];
                if(set.containsKey(temp))
                {
                    Integer[] map = set.get(temp);
                    if(map[1] == -1){
                        map[1] = i;
                    }
                }else{
                    set.put(arr[i], new Integer[]{i,-1});
                }
            }
            boolean flag = true;
            for(Integer key : set.keySet()){
                Integer[] map = set.get(key);
                if(map[1] != -1){
                    System.out.println(map[0] + " " + map[1]);
                    flag = false;
                    break;
                }
            }
            if(flag){
                System.out.println(-1 + " " + -1);
            }
            
        }

        sc.close();
    }
    
}

