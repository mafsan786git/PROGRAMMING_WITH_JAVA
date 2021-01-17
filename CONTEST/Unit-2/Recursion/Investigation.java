import java.io.*;
import java.util.*;

public class Investigation {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        String number = input.nextToken();
        String[] keypad = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        KeyPadPermutation(keypad,number,new StringBuilder(""),0,0);
    }
    //with loop
    /*private static void KeyPadPermutation(String[] keypad, String number,StringBuilder ans,int row) {

        if(row == number.length())
        {
            System.out.println(ans.toString());
            return ;
        }
        for (int i = 0; i < keypad[number.charAt(row)-'0'].length(); i++) {
            ans.append(keypad[number.charAt(row)-'0'].charAt(i));
            KeyPadPermutation(keypad, number, ans, row+1);
            ans.deleteCharAt(ans.length() - 1);
        }

    }**/

    private static void KeyPadPermutation(String[] keypad, String number,StringBuilder ans,int row,int col) {

        if(row == number.length())
        {
            System.out.println(ans.toString());
            return ;
        }
        if(col == keypad[number.charAt(row)-'0'].length())
        return ;
            ans.append(keypad[number.charAt(row)-'0'].charAt(col));
            KeyPadPermutation(keypad, number, ans, row+1,0);
            ans.deleteCharAt(ans.length() - 1);
            KeyPadPermutation(keypad, number, ans, row,col+1);

    }
    
}
