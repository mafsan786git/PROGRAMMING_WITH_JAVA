import java.io.*;
import java.util.*;

public class PhoneCombination {
    public static void main(String[] args) {
        String str = "";
        
        keypadCombination(str,0,0,new StringBuilder(""));
    }

    private static void keypadCombination(String str,int row,int col,StringBuilder ans){
        if(row == str.length())
        {
            System.out.println(ans);
            return ;
        }
        if(Character.isWhitespace(keyChar(str.charAt(row)-'0',col)))
            return ;
        ans.append(keyChar(str.charAt(row)-'0',col));
        keypadCombination(str, row+1, 0, ans);
        ans.deleteCharAt(ans.length()-1);
        keypadCombination(str, row, col+1, ans);
    }
    private static char keyChar(int row,int col){
        String[] keypad = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        if(col == keypad[row].length())
            return ' ';
        return keypad[row].charAt(col);
    }
}
