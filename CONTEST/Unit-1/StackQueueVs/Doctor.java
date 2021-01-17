import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Doctor {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        input = br.readLine().split(" ");
        int[] name = new int[n];
        for (int i = 0; i < name.length; i++) {
            name[i] = Integer.parseInt(input[i].trim());
        }
        input = br.readLine().split(" ");
        Queue<Integer> queue1 = new LinkedList<>();
        for (int i = 0; i < name.length; i++) {
            queue1.add(Integer.parseInt(input[i].trim()));
        }
        
        Queue<Integer> queue2 = new LinkedList<>();
        Queue<Integer> temp;
        long TotalMove = 0;
        for (int i = 0; i < name.length; i++) {
            while (!queue1.isEmpty() && name[i] != queue1.peek()) {
                TotalMove++;
                queue2.add(queue1.remove());
            }
            // System.out.println("total before if -> " + TotalMove);
            if(i != n-1)
            {   TotalMove++;
                queue1.remove();
            }
            System.out.println(name[i] + " total -> " + TotalMove);
            while(!queue1.isEmpty())
                queue2.add(queue1.remove());
            temp = queue1;
            queue1 = queue2;
            queue2 = temp;
        }

        System.out.println(TotalMove);
    }
    
}
