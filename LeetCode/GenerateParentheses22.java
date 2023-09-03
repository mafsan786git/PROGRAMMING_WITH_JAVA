import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses22 {
    public static void main(String[] arg){
        List<String> answer = new ArrayList<>();
        int number = 3;
        generateAllParenthesesCombinationOPtim(number,0,0,answer,new StringBuilder());
        System.out.println(answer);
    }

    public static void generateAllParenthesesCombinationOPtim(int n,int open,int close,List<String> answer,StringBuilder combination){
        if(open == n && n == close){
            answer.add(combination.toString());
            return ;
        }
        if(open > n || close > open){
            return ;
        }
            generateAllParenthesesCombinationOPtim(n,open+1,close,answer,combination.append("("));
            combination.deleteCharAt(combination.length()-1);
            generateAllParenthesesCombinationOPtim(n,open,close+1,answer,combination.append(")"));
            combination.deleteCharAt(combination.length()-1);
    }

    public static void generateAllParenthesesCombination(int open,int close,List<String> answer,StringBuilder combination){
        if(open == 0 && open == close){
            if(isValid(combination)){
                answer.add(combination.toString());
            }
            return ;
        }
        if(open > 0){
            generateAllParenthesesCombination(open-1,close,answer,combination.append("("));
            combination.deleteCharAt(combination.length()-1);
        }
        if(close > 0){
            generateAllParenthesesCombination(open,close-1,answer,combination.append(")"));
            combination.deleteCharAt(combination.length()-1);
        }
    }

    public static boolean isValid(StringBuilder combination){
        Stack<Character> valid = new Stack<>();
        for (int index = 0;index< combination.length();index++) {
            if(combination.charAt(index) == '('){
                valid.add('(');
                continue;
            }
            if(combination.charAt(index) == ')' && !valid.isEmpty()){
                valid.pop();
            }
        }
        return valid.isEmpty();
    }
}
