import java.util.Arrays;

public class PermutationInString567 {
    public static void main(String[] args) {
        boolean check = checkPermutationOfStringInMainStringOpt2("ab","eidbaooo");
        System.out.println(check);
    }

    public static boolean checkPermutationOfStringInMainString(String str1,String str2){
        if(str1.length() > str2.length()) return false;
        String hashKeyOfS1 = createHashKeyUsingSet(0,str1.length(),str1);
        for(int index=0;index<str2.length()-str1.length()+1;index++){
            String hashKeyOfS2 = createHashKeyUsingSet(index, index+str1.length(),str2);
            if(hashKeyOfS1.equals(hashKeyOfS2)){
                return true;
            }
        }
        return false;
    }

    public static String createHashKeyUsingSet(int start,int end,String str){
        char[] count = new char[26];
        while(start < end){
            count[str.charAt(start)-'a']++;
            start++;
        }
        return new String(count);
    }

    public static boolean checkPermutationOfStringInMainStringOpt1(String str1,String str2){
        if(str1.length() > str2.length()) return false;
        int[] count = createCount(0,str1.length(),str1);
        String hashKeyOfS1 = Arrays.toString(count);
        count = createCount(0,str1.length(),str2);
        for(int index=1;index<str2.length()-str1.length()+1;index++){
            String hashKeyOfS2 = adjustCount(index-1, index+str1.length()-1,str2,count);
            if(hashKeyOfS1.equals(hashKeyOfS2)){
                return true;
            }
        }
        return false;
    }

    public static String adjustCount(int start,int end,String str,int[] count){
        count[str.charAt(start)-'a']--;
        count[str.charAt(end)-'a']++;
        return Arrays.toString(count);
    }

    public static int[] createCount(int start,int end,String str){
        int[] count = new int[26];
        while(start < end){
            count[str.charAt(start)-'a']++;
            start++;
        }
        return count;
    }

    public static boolean checkPermutationOfStringInMainStringOpt2(String str1,String str2){
        if(str1.length() > str2.length()) return false;
        int[] count1 = createCount(0,str1.length(),str1);
        int[] count2 = createCount(0,str1.length(),str2);
        int matches = findMatches(count1,count2);
        int lastIndex = 0;
        for(int index=str1.length();index<str2.length();index++){
            if(matches == 26) return true;
            int rightIndex = str2.charAt(index)-'a';
            count2[rightIndex]++;
            if(count1[rightIndex] == count2[rightIndex]) matches++;
            else if(count1[rightIndex]+1 == count2[rightIndex]) matches--;

            int leftIndex = str2.charAt(lastIndex)-'a';
            count2[leftIndex]--;
            if(count1[leftIndex] == count2[leftIndex]) matches++;
            else if(count1[leftIndex]-1 == count2[leftIndex]) matches--;
            lastIndex++;
        }
        if(matches == 26) return true;
        return false;
    }

    public static int findMatches(int[] count1,int[] count2){
        int matches = 0;
        for(int index=0;index < 26;index++){
            if(count1[index] == count2[index]) matches++;
        }
        return matches;
    }
    
    



}
