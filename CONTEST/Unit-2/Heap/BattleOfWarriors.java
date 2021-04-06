import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BattleOfWarriors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());
            while(n-- > 0)
                p.add(sc.nextInt());
            while(p.size() >= 2){
                int a = p.poll();
                int b = p.poll();
                if(a != b){
                    p.add((a+b)/3);
                }
            }
            if(p.isEmpty())
                System.out.println(-1);
            else
                System.out.println(p.poll());
        }
        sc.close();
    }
}