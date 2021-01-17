import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Parenthesis {
    public static void main(String[] arg) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int t = Integer.parseInt(input[0]);
        while(0 <t--){
            input = br.readLine().split(" ");
            String str = input[0];
            Stack<Character> stack = new Stack<>();
            boolean flag = true;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if(c == '(' || c == '{' || c == '[')
                {
                    stack.push(c);
                }
                else{
                    if(c == '}')
                    {   
                        if(stack.isEmpty() || stack.peek() != '{'){
                            flag = false;
                            break;
                        }else
                            stack.pop();
                        
                    }
                    else if(c == ']')
                    {   
                        if(stack.isEmpty() || stack.peek() != '['){
                            flag = false;
                            break;
                        }else
                            stack.pop();
                    }
                    else if(c == ')')
                    {   
                        if(stack.isEmpty() || stack.peek() != '('){
                            flag = false;
                            break;
                        }else
                            stack.pop();
                    }
                        
                }
            }
            if(flag && stack.isEmpty())
                System.out.println("balanced");
            else
                System.out.println("not balanced");
        }
    }
    
}
