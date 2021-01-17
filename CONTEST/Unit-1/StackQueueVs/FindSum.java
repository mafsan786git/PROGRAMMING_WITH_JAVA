import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class FindSum {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        input = br.readLine().split(" ");
        ArrayList<Long> arr = new ArrayList<>();
        ArrayList<Integer> y = new ArrayList<>();
        ArrayList<Integer> x = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            arr.add(Long.parseLong(input[i]));
            y.add(-1);
            x.add(-1);
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = n-1; i >= 0; i--) {
                while(!stack.isEmpty() && arr.get(i) > arr.get(stack.peek())){
                    x.set(stack.pop(),i+1);
                }
            stack.push(i);
        }

        System.out.println(x);
        stack.clear();
        for (int i = 0; i<n; i++) {
                while(!stack.isEmpty() && arr.get(i) > arr.get(stack.peek())){
                    y.set(stack.pop(),i+1);
                }
            stack.push(i);
        }
        System.out.println(y);
        for (int i = 0; i < n; i++) {
            System.out.print(x.get(i)+y.get(i) + " ");
        }
        System.out.println();
    }
    
}
