import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BlackFriday {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            PriorityQueue<Long> p = new PriorityQueue<>(Collections.reverseOrder());
            while(n-- > 0){
                 p.add(sc.nextLong());
            }
            while(m-- > 0 && p.peek() != 0){
                long x = Math.round(p.poll()/2);
                p.add(x);
            }
            long sum = 0;
            while(p.isEmpty() == false){
                sum += p.poll();
            }
            System.out.println(sum);
        }
        sc.close();
    }
}
