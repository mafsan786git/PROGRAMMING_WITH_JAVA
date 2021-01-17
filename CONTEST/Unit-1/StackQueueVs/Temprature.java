import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Stack;

public class Temprature {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        input = br.readLine().split(" ");
        int[] arr = new int[n];
        int[] output = new int[n];
        for(int i=0;i<input.length;i++){
            arr[i]  = Integer.parseInt(input[i]);
        }
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++)
        {
            if(stack.isEmpty())
                stack.push(i);
            else{
                while(!stack.isEmpty() && arr[i] > arr[stack.peek()]){
                    output[stack.peek()] = i-stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }
        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i] + " ");
        }
        System.out.println();
    }
    
}
