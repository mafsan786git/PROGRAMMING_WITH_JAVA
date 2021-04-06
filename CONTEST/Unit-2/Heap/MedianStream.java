import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MedianStream {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> max_p = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> min_p = new PriorityQueue<>();
        int x;
        x = sc.nextInt();
        if(n == 1){
            System.out.println(x);
            n--;
        }
        else{
            max_p.add(x);
            x = sc.nextInt();
            System.out.println((x+max_p.peek())/2);
            if(x > max_p.peek())
                min_p.add(x);
            else{
                min_p.add(max_p.poll());
                max_p.add(x);
            }
            n -= 2;
        }
        while(n-- > 0){
            x = sc.nextInt();
            if(max_p.size()-min_p.size() == 0){
                if(max_p.peek() > x)
                    max_p.add(x);
                else{
                    min_p.add(x);
                    max_p.add(min_p.poll());
                }
            }else{
                if(max_p.peek() > x){
                    max_p.add(x);
                    min_p.add(max_p.poll());
                }else{
                    min_p.add(x);
                }
            }
            if((max_p.size()+min_p.size())%2 == 0){
                System.out.println((min_p.peek()+max_p.peek())/2);
            }else
                System.out.println(max_p.peek());
        }
        sc.close();
    }
}
