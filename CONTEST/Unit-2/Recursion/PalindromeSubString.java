
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PalindromeSubString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        List<List<String>> list = new ArrayList<>();
        PalindromSub(new StringBuilder(str),new StringBuilder(""),list);
        // System.out.println(str);
        for(List<String> val : list)
            System.out.println(val);
        sc.close();
    }


    static void PalindromSub(StringBuilder str,StringBuilder ans,List<List<String>> list){
        if(0 == str.length())
        {
            String temp = ans.toString();
            
            List<String> lt = new ArrayList<>(Arrays.asList(temp.split(" ")));
            list.add(lt);
            return ;
        }

        for (int i = 1; i <=str.length(); i++) {
            String rem = str.substring(i);
            String sub = str.substring(0,i);
            if(!Palindrome(sub))
                continue;
            PalindromSub(new StringBuilder(rem),new StringBuilder(ans + sub + " "),list);
        }
    }

    static boolean Palindrome(String str)
    {
        for(int i = 0;i<str.length()/2;i++)
        {
            if(str.charAt(i) != str.charAt(str.length()-i-1))
                return false;
        }

        return true;
    }
    
}
