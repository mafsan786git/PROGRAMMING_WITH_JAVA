import java.io.IOException;
import java.io.*;
import java.util.*;
public class PhoneNumber {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        String num = input.nextToken();
        String[] arr = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        LetterCombination(arr, num,new StringBuilder(""), 0);
        // for(String str : arr)
            // System.out.println(str);
    }

    static void LetterCombination(String[] arr, String num,StringBuilder ans,int row){
        if(row == num.length())
        {
            System.out.println(ans.toString());
            return ;
        }
        // int index = num.charAt(0)-'0';
        for (int i = 0; i < arr[num.charAt(row)-'0'].length(); i++) {
            ans.append(arr[num.charAt(row)-'0'].charAt(i));
            LetterCombination(arr, num,ans, row+1);
            ans.deleteCharAt(ans.length()-1);
        }
    }
    
}
