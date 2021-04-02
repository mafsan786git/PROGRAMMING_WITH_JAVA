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
        int left = 0;
        int right = k-1;
        while(!pq.isEmpty()){
            Pair p = pq.peek();
            while(p.idx < left){
                pq.poll();
                p = pq.peek();
            }
            if(p.idx >= left && p.idx <= right)
                System.out.println(p.val + " " +p.idx);
            
            left++;
            right++;
            if(right >= n)
                break;
            pq.add(new Pair(arr[right],right));
            // for(Pair rp : pq){
            //     System.out.print(rp.val+ " - ");
            // }
            // System.out.println();
        }
        System.out.println();
        sc.close();
    }
}

/**
 * 21 4
-7923 -5741 -5026 -14401 30243 17984 -17477 -15309 -23705 13616 20428 27531 23603 -11535 -18344 -9583 -2965 -2709 1870 405 11428
 */
