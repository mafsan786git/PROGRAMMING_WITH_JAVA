import java.util.Arrays;

public class LogestSubstring3 {
    /*
     * pwwkew
     * p =0
     * w =1->2
     *  
     * 
     * abcabcbb
     * a = 0
     * b = 1
     * c = 2
     * 
     * 
     * 
     * maxCount = 3
     * count = currentIndex - repeatingIndex
     */
    public static void main(String[] args) {
        int maxLength = lengthOfLongestSubstringNonRepeating(" ");
        System.out.println(maxLength);
    }

    public static int lengthOfLongestSubstringNonRepeating(String s){
        if(s.length() == 0){
            return 0;
        }
        int lastIndex = 0;
        int[] charSet = new int[128];
        Arrays.fill(charSet, -1);
        int maxLength = 0;
        int count = 0;
        for(int currentIndex = 0;currentIndex < s.length();currentIndex++){
            int currentCharIndex = s.charAt(currentIndex);
            if(charSet[currentCharIndex] < lastIndex){
                count = count+1;
            }else{
                lastIndex = charSet[currentCharIndex];
                count = currentIndex - lastIndex;
            }
            maxLength = Math.max(maxLength, count);
            charSet[currentCharIndex] = currentIndex;
        }
        return maxLength;
    }

    
}
