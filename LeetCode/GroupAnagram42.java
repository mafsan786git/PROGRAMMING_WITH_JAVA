import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
public class GroupAnagram42 {
    public static void main(String[] args) {
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        List<List<String>> answer = groupAnagramsOptimised(strs);
        System.out.println(answer);
    }


    public static List<List<String>> groupAnagramsWithSorting(String[] strs) {
        HashMap<String,List<String>> hashMapOfAnagram = new HashMap<>();
        for(int index=0;index < strs.length; index++){
            char[] wordChar = strs[index].toCharArray();
            Arrays.sort(wordChar);
            String word  = new String(wordChar);
            if(hashMapOfAnagram.containsKey(word)){
                List<String> groupOfAnagrams = hashMapOfAnagram.get(word);
                groupOfAnagrams.add(strs[index]);
            }else{
                hashMapOfAnagram.put(word, new ArrayList<>(List.of(strs[index])));
            }
        }
        List<List<String>> answer = new ArrayList<>();
        for (List<String> anagrams : hashMapOfAnagram.values()) {
            answer.add(anagrams);
        }
        return answer;
    }

    public static List<List<String>> groupAnagramsOptimised(String[] strs) {
        HashMap<String,List<String>> hashMapOfAnagram = new HashMap<>();
        for(int index=0;index < strs.length; index++){
            String hashKey = createHashKey(strs[index]);
            if(hashMapOfAnagram.containsKey(hashKey)){
                List<String> groupOfAnagrams = hashMapOfAnagram.get(hashKey);
                groupOfAnagrams.add(strs[index]);
            }else{
                hashMapOfAnagram.put(hashKey, new ArrayList<>(List.of(strs[index])));
            }
        }
        List<List<String>> answer = new ArrayList<>();
        for (List<String> anagrams : hashMapOfAnagram.values()) {
            answer.add(anagrams);
        }
        return answer;
    }

    public static String createHashKey(String str){
        char[] count = new char[26];
        for(char c : str.toCharArray()){
            count[c-'a']++;
        }
        return new String(count);
    }
}
