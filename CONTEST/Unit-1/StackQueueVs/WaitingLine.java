import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class WaitingLine {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        Queue<Integer> queue = new LinkedList<>();
        while(0 < n--){
            input = br.readLine().split(" ");
            String c = input[0];
            int x=0;
            if(input.length  == 2)
                 x = Integer.parseInt(input[1]);
            switch (c){
                case "E":
                    queue.add(x);
                    System.out.println(queue.size());
                    break;
                case "D":
                    if(queue.isEmpty())
                        System.out.println(-1 + " " + 0);
                    else {
                        int temp = queue.peek();
                        queue.remove();
                        System.out.println(temp + " " + queue.size());
                    }
                    break;

            }
            
        }
    }
}
