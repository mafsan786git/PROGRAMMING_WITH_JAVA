import java.util.HashSet;
import java.util.Set;

public class LongestRepeating424 {
    /**
     * k = 3
     * AABACCBCCCCC
     * maxFreOfChar = 1 -> 2->3
     * totalOp = 1->2->3->4
     *      if k == totalOp:
     *          maxCount
     * last = 0
     * current = 0->1->2->3->4->5->6
     * 
     */
    public static void main(String[] args){
        int answer = LongestRepeatingSubstringOptimised("AABABBA", 0);
        System.out.println(answer);
    }

    public static int LongestRepeatingSubstringOptimised(String str,int k){
        int lastIndex = 0;
        int maxFreqOfChar = 0;
        int largestSubString = 0;
        char[] charCount = new char[26];
        for(int currentIndex = 0;currentIndex < str.length();currentIndex++){
            maxFreqOfChar = Math.max(maxFreqOfChar, ++charCount[str.charAt(currentIndex)-'A']);
            if(currentIndex-lastIndex+1-maxFreqOfChar  > k){
                charCount[str.charAt(lastIndex)-'A']--;
                lastIndex++;
            }
            largestSubString = Math.max(largestSubString, currentIndex-lastIndex+1);
        }
        return largestSubString;
    }

    public static int LongestRepeatingSubstring(String str,int k){
        int lastIndex = 0;
        int maxFreqOfChar = 0;
        int largestSubString = 0;
        char[] charCount = new char[26];
        for(int currentIndex = 0;currentIndex < str.length();currentIndex++){
            maxFreqOfChar = Math.max(maxFreqOfChar, ++charCount[str.charAt(currentIndex)-'A']);
            if(currentIndex-lastIndex+1-maxFreqOfChar  > k){
                while(currentIndex-lastIndex+1-maxFreqOfChar > k){
                    charCount[str.charAt(lastIndex)-'A']--;
                    maxFreqOfChar = maxCharFrequency(charCount);
                    lastIndex++;
                }
            }
            largestSubString = Math.max(largestSubString, currentIndex-lastIndex+1);
        }
        return largestSubString;
    }
    public static int maxCharFrequency(char[] charCount){
        int maxFreqOfChar = 0;
        for(int index=0;index<charCount.length;index++){
            maxFreqOfChar = Math.max(maxFreqOfChar, charCount[index]);
        }
        return maxFreqOfChar;
    }
}