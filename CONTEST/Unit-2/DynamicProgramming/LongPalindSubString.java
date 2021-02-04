
import java.util.*;
public class LongPalindSubString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int maxLen = 1;
        StringBuilder subString = new StringBuilder("");
        for (int i = 0; i < str.length()-1; i++) {
            for(int j = i; j < str.length(); j++) {
                if(isPalindrome(str,i,j) && maxLen < (j-i+1)){
                    maxLen = j-i+1;
                    subString = new StringBuilder(str.substring(i, j+1));
                }
            }
        }
        System.out.println(isPalindromeDp(str));
        System.out.println(subString);
        sc.close();
    }
    //Dp for longest Palindrome substring
    private static int isPalindromeDp(String str){
        int[][] dp = new int[str.length()][str.length()];
        int left = 0,right=0;
        for (int i = 0; i < dp.length; i++) {
            int k = i;
            for (int j = 0; j < dp.length-i; j++) {
                if(k == j){dp[j][k++] = 1; continue;}
                if(str.charAt(k) == str.charAt(j)){
                    if(k-1 < j+1 || dp[j+1][k-1] != 0){
                        // System.out.println((j+1) + " -- " + (k-1));
                        dp[j][k]  = dp[j+1][k-1] + 2;
                        left = j;right = k;
                    }
                }
                k++;
            }
        }
        System.out.println(str.substring(left, right+1));
        return right-left+1;
    }

    private static boolean isPalindrome(String str, int i, int j) {
        while(i < j){
            if(str.charAt(i) != str.charAt(j))
                return false;
            i++;j--;
        }
        return true;
    }
    
}
