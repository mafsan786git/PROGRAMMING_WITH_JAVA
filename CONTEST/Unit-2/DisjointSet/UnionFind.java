import java.util.Arrays;
import java.util.Scanner;

public class UnionFind {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] arr = new int[n+1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = i;
        }
        while(q-- > 0){
            int type = sc.nextInt();
            int first = sc.nextInt();
            int second = sc.nextInt();
            if(type == 1){
                unionSecondOptimise(arr, first, second);
            }else{
                System.out.println((headFind(arr, first) == headFind(arr, second)) ? "True" : "False");
            }
            System.out.println(Arrays.toString(arr));
        }
        
        sc.close();
    }
    /**Brute force approach 
     * Time complexity = O(N) per operation
     *
    private static void unionNaiveApproach(int[] arr,int first,int second){
        int headOfSecond = arr[second];
        for (int i = 1; i < arr.length; i++) {
                if(arr[i] == headOfSecond)
                    arr[i] = arr[first];
        }
    }
    */
    /**First optimisation 
     * Time (log(n)) avaerage but O(n) worst case

    private static void unionFirstOptimise(int[] arr,int first ,int second){
        int headFirst = headFind(arr,first);
        int headSecond = headFind(arr,second);
        arr[headSecond] = headFirst;
        System.out.println(headFirst +" ---- " + headSecond);
    }
    private static int headFind(int[] arr,int node) {
        while(arr[node] != node)
            node = arr[node];
        return node;
    }
    */
    /**Union by path 
     * Time O(log(n)) beacuse flattening in headFind
     * type path compression
    */
    private static void unionSecondOptimise(int[] arr,int first ,int second){
        int headFirst = headFind(arr,first);
        int headSecond = headFind(arr,second);
        arr[headSecond] = headFirst;
        System.out.println(headFirst +" ---- " + headSecond);
    }
    private static int headFind(int[] arr,int node) {
        while(arr[node] != node){
            arr[node] = arr[arr[node]];
            node = arr[node];
        }
        return node;
    }
  
}