import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class SignalCapacity {
    public static void main(String[] arg) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int t = Integer.parseInt(input[0]);
        while(0 < t--){
            input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            input = br.readLine().split(" ");
            long[] arr = new long[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Long.parseLong(input[i]);
            }
            long[] output = new long[n];
            Stack<Integer> stack = new Stack<>();
            int count=0;
            for (int i = 0; i < arr.length; i++) {
                count=0;
                while(!stack.isEmpty() && arr[i] >= arr[stack.peek()]){
                    count += output[stack.pop()];
                }
                stack.push(i);
                output[i] = count+1;
            }
            for (Long val : output) {
                System.out.print(val+ " ");
            }
            System.out.println();
        }
    }
    
}
