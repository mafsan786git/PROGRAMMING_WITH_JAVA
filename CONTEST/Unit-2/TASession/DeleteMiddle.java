import java.util.Stack;

public class DeleteMiddle {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for(int i=1;i<=5;i++)
            stack.push(i);
        int index = stack.size()/2+1;
        removeMiddle(stack,index);
        for(Integer val:stack)
            System.out.println(val);
    }

    private static void removeMiddle(Stack<Integer> stack,int index) {
        if(stack.size() == index)
        {
            stack.pop();
            return;
        }
        int temp = stack.pop();
        removeMiddle(stack, index);
        stack.push(temp);
    }
    
}
