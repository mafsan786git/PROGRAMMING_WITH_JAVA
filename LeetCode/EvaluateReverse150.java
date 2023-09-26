import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EvaluateReverse150 {
    public static void main(String[] args) {
        int answer = evaluateExpression(new String[]{"4","3","-"});
        System.out.println(answer);
    }

    private static int evaluateExpression(String[] tokens){
        if(tokens.length == 0) return 0;
        Stack<Integer> operand = new Stack<>();
        for (String variable : tokens) {
            int firstOparand;
            int secondOparand;
            switch (variable) {
                case "+":
                    firstOparand = operand.pop();
                    secondOparand = operand.pop();
                    operand.push(firstOparand + secondOparand);
                    break;
                case "-":
                    firstOparand = operand.pop();
                    secondOparand = operand.pop();
                    operand.push(secondOparand - firstOparand);
                    break;
                case "*":
                    firstOparand = operand.pop();
                    secondOparand = operand.pop();
                    operand.push(firstOparand * secondOparand);
                    break;
                case "/":
                    firstOparand = operand.pop();
                    secondOparand = operand.pop();
                    operand.push(secondOparand / firstOparand);
                    break;
                default:
                    operand.push(convertStringToNumber(variable));
            }
        }
        return operand.pop();
    }

    private static int convertStringToNumber(String variable){
        return Integer.parseInt(variable);
    }
}
