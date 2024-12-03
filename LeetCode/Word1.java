import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Word1 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        List<String> wordDict = new ArrayList<>(Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"));
        System.out.print(wordBreak(str,wordDict));

    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s,0,wordDict);
    }


    private static boolean wordBreak(String str,int index, List<String> wordDict){
        if(index == str.length()) return true;

        for(int i=0; i < wordDict.size(); i++){
            String dict = wordDict.get(i);
            if(str.startsWith(dict,index)){
                if(wordBreak(str,index+dict.length(),wordDict)) return true;
            }
        }

        return false;
    }

}