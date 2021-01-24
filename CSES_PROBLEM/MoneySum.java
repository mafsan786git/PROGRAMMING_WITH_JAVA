import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class MoneySum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashSet<Integer> map = new HashSet<>();
        while(n-- > 0){
            int x = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for(Integer val : map){
                arr.add(val+x);
            }
            map.add(x);
            for(Integer val : arr){
                map.add(val);
            }
        }
        System.out.println(map.size());
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(Integer val : map){
            treeSet.add(val);
        }
        for(Integer val : treeSet){
            System.out.print(val + " ");
        }
        System.out.println();
        sc.close();

    }
}