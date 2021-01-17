import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class MinRemove {
        static String minRemoveToMakeValid(String s) {
            Stack<Character> stack = new Stack<>();
            Stack<Integer> stackIn = new Stack<>();
            StringBuffer output = new StringBuffer();
           
            output.append(s);
            for(int i=0;i<s.length();i++){
                char c = s.charAt(i);
                if(c == '(')
                {
                    stack.push(c);
                    stackIn.push(i);
                }else if(c == ')'){
                    if(stack.isEmpty()){
                        stackIn.push(i);
                    }else{
                        stack.pop();
                        stackIn.pop();
                    }
                }
            }
            // ArrayList<Integer> index = new ArrayList<>();
            // Iterator value = stackIn.iterator();
            // while(value.hasNext())
            //     index.add(value.next());
            while(!stackIn.isEmpty()){
                output.deleteCharAt(stackIn.pop());
            }
            return output.toString();
        }
        public static void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] input = br.readLine().split(" ");
            System.out.println(minRemoveToMakeValid(input[0]));
            
        }
}
