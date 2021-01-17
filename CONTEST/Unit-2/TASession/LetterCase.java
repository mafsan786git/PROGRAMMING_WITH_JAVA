import java.util.ArrayList;
import java.util.List;

public class LetterCase {
    public static void main(String[] args) {
        String str = "a1b2";
        List<String> list = new ArrayList<>();
        allLetterCase(new StringBuilder(str),0,list);
        System.out.println(list);
    }
    private static void allLetterCase(StringBuilder ans,int index,List<String> list)
    {
        if(index == ans.length())
        {
            list.add(ans.toString());
            return ;
        }
        allLetterCase(ans, index+1, list);
        if(!Character.isDigit(ans.charAt(index))){
            if(Character.isUpperCase(ans.charAt(index)))
                    ans.setCharAt(index,Character.toLowerCase(ans.charAt(index)));
                else
                    ans.setCharAt(index,Character.toUpperCase(ans.charAt(index)));
            allLetterCase(ans, index+1, list);
        }
        // ans.setCharAt(index,Character.toLowerCase(ans.charAt(index)));
    }

    //This is also important program...
    public void backtrack(List<String> ans, int i, char[] S){
        if(i==S.length)
            ans.add(new String(S));
        else{
            if(Character.isLetter(S[i])){ //If it's letter
                S[i] = Character.toUpperCase(S[i]);
                backtrack(ans, i+1, S); //Upper case branch
                S[i] = Character.toLowerCase(S[i]);
                backtrack(ans, i+1, S); //Lower case branch
            }
            else
                backtrack(ans, i+1, S); 
        }
    }
    
}
