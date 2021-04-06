import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PriorityQueueUsing2DArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer[]> p = new PriorityQueue<>(new Comparator<Integer[]>(){
            public int compare(Integer[] a,Integer[] b){
                return a[0]-b[0];
            }
        });
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            p.add(new Integer[]{a,b});
        }
        while(!p.isEmpty()){
            System.out.println(Arrays.toString(p.poll()));
        }
        sc.close();
    }
    
}
