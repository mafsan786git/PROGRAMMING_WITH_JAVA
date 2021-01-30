import java.io.*;
import java.util.*;
public class StringBalance {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int test = 0;
        while(true){
            int count = 0;
            StringTokenizer input = new StringTokenizer(br.readLine());
            Stack<Integer> stack = new Stack<>(); 
            String braces = input.nextToken().toString();
            // System.out.println(braces);
            if(braces.charAt(0) == '-')
                break;
            test++;
            int flag = -1;
            for (int i = 0; i < braces.length(); i++) {
                if(braces.charAt(i) == '}')
                {
                    if(stack.isEmpty()){
                        flag = i;
                        stack.push(i);
                        count++;
                    }
                    else{
                        int index = stack.pop();
                        if(index == flag)
                            flag = -1;
                    }
                }else{
                    stack.push(i);
                }
            }
            while(!stack.isEmpty()){
                int index = stack.pop();
                count++;
                if(stack.isEmpty() == false)
                    stack.pop();
            }
            System.out.println(test+". "+count);
        }
    }
    
}
