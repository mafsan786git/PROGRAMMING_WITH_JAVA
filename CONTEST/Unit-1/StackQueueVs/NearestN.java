import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class NearestN {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int[] arr = new int[n];
        input = br.readLine().split(" ");
        int[] output = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
            output[i] = -1;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = n-1; i >=0; i--) {
            while(!stack.isEmpty() && arr[i] < arr[stack.peek()])
            {
                output[stack.pop()] = i;
            }
            stack.push(i);
        }
        for (int i = 0; i < n; i++) {
            if(output[i] == -1)
                System.out.print(-1 + " ");
            else
                System.out.print(arr[output[i]] + " ");
        }
        System.out.println();
    }
}
