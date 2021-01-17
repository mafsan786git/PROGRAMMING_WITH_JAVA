import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;


public class RectangleArea {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int t = Integer.parseInt(input[0]);
        while(0 < t--){
            input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            input = br.readLine().split(" ");
            int[] arr = new int[n];
            int[] left = new int[n];
            int[] right = new int[n];
            for (int i = 0; i < right.length; i++) {
                arr[i] = Integer.parseInt(input[i]);
                left[i] = -1;
                right[i] = n;
            }
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < right.length; i++) {
                while(!stack.isEmpty() && arr[i] < arr[stack.peek()])
                {
                    right[stack.pop()] = i;
                }
                stack.push(i);
            }
            stack.clear();
            for (int i = n-1; i >=0; i--) {
                while(!stack.isEmpty() && arr[i] < arr[stack.peek()])
                {
                    left[stack.pop()] = i;
                }
                stack.push(i);
            }
            long result = 0;
            for (int i = 0; i < right.length; i++) {
                result = Math.max(result, (right[i]-left[i]-1)*arr[i]);
            }
            System.out.println(Arrays.toString(right));
            System.out.println(Arrays.toString(left));
            System.out.println(result);
            
        }
    }
    
}
