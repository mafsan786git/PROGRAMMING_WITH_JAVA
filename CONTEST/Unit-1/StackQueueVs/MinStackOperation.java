import java.io.IOException;
import java.util.Stack;

public class MinStackOperation {
    private Stack<Integer> mainStack;
    private Stack<Integer> auxStack;

    public MinStackOperation(){
        mainStack = new Stack<>();
        auxStack  = new Stack<>();
    }

    public void push(int num){
        mainStack.push(num);
        if(auxStack.isEmpty())
            auxStack.push(num);
        else{
            if(auxStack.peek() >= num)
                auxStack.push(num);
        }
    }
    
    public int pop(){
        if(empty()){
            System.out.println("Stack is underFlow...");
            return -1;
        }

        int top = mainStack.pop();

        if(top == auxStack.peek()){
            auxStack.pop();
        }

        return top;
    }

    public int peek(){
        return mainStack.peek();
    }

    public int size(){
        return mainStack.size();
    }
    public int min(){
        if(auxStack.isEmpty())
        {
            System.out.println("Stack is underflow.");
            return -1;
        }
        return auxStack.peek();
    }
    public boolean empty(){
        return mainStack.isEmpty();
    }
    public static void main(String[] args) throws IOException {
        MinStackOperation stack = new MinStackOperation();
        stack.push(6);
        System.out.println("Min -> "+ stack.min());
        stack.push(7);
        System.out.println("Min -> "+ stack.min());
        stack.push(8);
        System.out.println("Min -> "+ stack.min());
        stack.push(5);
        System.out.println("Min -> "+ stack.min());
        stack.push(3);
        System.out.println("Min -> "+ stack.min());
        stack.pop();
        System.out.println("Min -> "+ stack.min());
        stack.push(10);
        System.out.println("Min -> "+ stack.min());
        stack.pop();
        System.out.println("Min -> "+ stack.min());
        stack.pop();
        System.out.println("Min -> "+ stack.min());
        

        
    }
    
}
