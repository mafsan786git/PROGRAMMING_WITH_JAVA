import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombination17 {

    /**
     * 2 --abc
     * 3 --def
     * 4 --ghi
     * 5 --jkl
     * 6 --mno
     * 
     * 23456
     * 23 --x === "ad","ae","af","bd","be","bf","cd","ce","cf"
     * x4 -- y
     * y5 --z
     * z6 ---finalresponse
     * 
     * 3*3 = 9
     * 9*3 = 27
     * 27*3 == 
     * 
     * @param arg
     */
    public static void main(String[] arg){
        String upperCase = "bhcsv23t4823bhj".toUpperCase();
        System.out.println(upperCase);
        Map<Character,String> mapOfLetters = createMapOfLetters();
        String digits = "23456789";
        letterCombinations(digits);
        // List<String> answer = new ArrayList<>();
        // for (int index = 0;index< digits.length();index++) {
        //     if(mapOfLetters.containsKey(digits.charAt(index))){
        //         String letterPad = mapOfLetters.get(digits.charAt(index));
        //         answer = createLetterCombination(answer,letterPad);
        //     }
        // }
        // System.out.println(answer);
    }


    public static List<String> letterCombinations(String digits) {
        String[] arr = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> str = new ArrayList<>();
        if(digits.length() == 0)
            return str;
        LetterCombination(str,arr,digits,new StringBuilder(""), 0);
        return str;
        
    }
    
    public static void LetterCombination(List<String> str,String[] arr, String num,StringBuilder ans,int row){
        if(row == num.length())
        {
            str.add(ans.toString());
            return ;
        }
        for (int i = 0; i < arr[num.charAt(row)-'0'].length(); i++) {
            ans.append(arr[num.charAt(row)-'0'].charAt(i));
            LetterCombination(str,arr, num,ans, row+1);
            ans.deleteCharAt(ans.length()-1);
        }
    }

    public static Map<Character,String> createMapOfLetters(){
        return new HashMap<>(){{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
    }

    public static List<String> createLetterCombination(List<String> letterCombination,String letterPad){
        List<String> answer = new ArrayList<>();
        for (int index = 0;index < letterPad.length();index++) {
            if(letterCombination.isEmpty()){
                answer.add(Character.toString(letterPad.charAt(index)));
            }else{
                for (String letter : letterCombination) {
                    answer.add(letter + letterPad.charAt(index));
                }
            }
        }
        return answer;
    }

}
