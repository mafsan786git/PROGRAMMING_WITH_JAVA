public class LongestPalindrom5 {
    /**
     * Given a string s, return the longest palindromic substring in s.
     * string : babad
     * 
     * first approach : travers all substring and check if its palindrome and max
     *      time : O(n^3)
     * 
     * second approach : 
     *  a b s c d e b s b s b  y  h  s  y  g  f  d
     *  0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17
     * 
     * @param args
     */
    public static void main(String[] args){
        String answer = longestPalindromicStringFromCenter("abscdebsbsbyhsygfd");
        System.out.println(answer);
        Integer x = Integer.MAX_VALUE;
    }

    public static String longestPalindromicString(String s){
        boolean[][] dp = new boolean[s.length()][s.length()];
        int[] ans = new int[]{0,0};
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < s.length()-1; i++) {
            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = true;
                ans[0] = i;
                ans[1] = i+1;
            }
        }
        for(int diff = 2; diff< s.length();diff++){
            for (int i = 0; i < s.length()-diff; i++) {
                int j = i + diff;
                if (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]) {
                    dp[i][j] = true;
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }
        return s.substring(ans[0], ans[1]+1);
    }

    //same time but iteration will be 2n -1 over n^2
    public static String longestPalindromicStringFromCenter(String s){
        int[] ans = new int[]{0,0};
        for(int i = 0; i< s.length();i++){
            int oddLength = expandFromCenter(i,i,s);
            if(oddLength > ans[1]-ans[0]+1){
                int dist = oddLength/2;
                ans[0] = i-dist;
                ans[1] = i+dist;
            }
            int evenLength = expandFromCenter(i,i+1,s);
            if(evenLength > ans[1]-ans[0]+1){
                int dist = (evenLength/2)-1;
                ans[0] = i-dist;
                ans[1] = i+1+dist;
            }

        }
        return s.substring(ans[0], ans[1]+1);
    }

    public static int expandFromCenter(int i,int j,String s){
        int left = i;
        int right = j;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }


}
 