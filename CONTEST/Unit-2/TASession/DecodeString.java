import java.util.*;
/**Use StringBuilder for mutation of string */
public class DecodeString {
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ']'){
                String temp = "";
                while(!stack.isEmpty() && stack.peek() != '['){
                    temp  = stack.pop() + temp;
                }
                
                String digit = "";
                if(!stack.isEmpty())
                    stack.pop();
                while(!stack.isEmpty()){
                    if(Character.isDigit(stack.peek()))
                    {
                        digit = stack.pop()+digit;
                    }else
                        break;
                }
                int num = Integer.parseInt(digit);
                String res = "";
                while(num-- > 0){
                    res += temp;
                }
                for (int j = 0; j < res.length(); j++) {
                    stack.push(res.charAt(j));
                }
            }else{
                stack.push(str.charAt(i));
            }
        }
        String result = "";
        for(Character val : stack){
            result += val;
        }
        System.out.println(result);
    }
    
}
