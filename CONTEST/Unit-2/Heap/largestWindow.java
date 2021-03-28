import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class largestWindow {
    static class Pair implements Comparator<Pair>{
        int val;
        int idx;
        public Pair(){}
        public Pair(int v,int i){
            val = v;
            idx = i;
        }
        @Override
        public int compare(Pair p1,Pair p2){
            return p2.val - p1.val;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        Queue<Pair> pq = new PriorityQueue<>(new Pair());
        for (int i = 0; i < k; i++){
            pq.add(new Pair(arr[i],i));
        }
        sc.close();
    }
}
