import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class NextSmallerSum {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        input = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        int[] output = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while(!stack.isEmpty() && arr[i] < arr[stack.peek()])
            {
                output[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        long sum = 0;
        for (int i = 0; i < output.length; i++) {
            sum += output[i];
        }
        System.out.println(sum);
    }
}
