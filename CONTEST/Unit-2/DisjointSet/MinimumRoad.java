import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class MinimumRoad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] arr = new int[n+1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = i;
        }
        while(q-- > 0){
            int first = sc.nextInt();
            int second = sc.nextInt();
            unionSecondOptimise(arr, first, second);
            // headFind(arr, first);
            // headFind(arr, second);
            System.out.println(Arrays.toString(arr));
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i < arr.length; i++) {
            headFind(arr, i);
            set.add(arr[i]); 
        }
        System.out.println(set.size()-1);
        System.out.println(Arrays.toString(arr));
        sc.close();
    }
    private static void unionSecondOptimise(int[] arr,int first ,int second){
        int headFirst = headFind(arr,first);
        int headSecond = headFind(arr,second);
        arr[headSecond] = headFirst;
    }
    private static int headFind(int[] arr,int node) {
        if(node == arr[node])
            return node;
        return arr[node] = headFind(arr, arr[node]);
    }
}
