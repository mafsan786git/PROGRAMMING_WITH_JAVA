import java.io.*;
import java.util.*;
/**
 * The solution to this question is a very popular algorithm used for:
    Spell correction and suggestion by search engines
    Computational Biology
    Machine Translation
    Information Extraction
    Speech Recognition
    NLP
    Needleman‐Wunsch Algorithm, etc. to name a few
    "Edit distance" (also known as Levenshtein distance) measures the minimum number of simple changes to move from one string to another. Possible changes include the insertion of a single character, the deletion of a single character, or the substitution from one character to another. Your program must calculate the edit distance between pairs of strings.
 */
public class EditDistanceDp{
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        // BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(input.nextToken());
        while(t-- > 0)
        {
            input = new StringTokenizer(br.readLine());
            String s1 = input.nextToken().toString();
            input = new StringTokenizer(br.readLine());
            String s2 = input.nextToken().toString();
            int longSub = longSubSequence(s1,s2);
            bw.write(longSub + "\n");
        }

        br.close();
        bw.close();
    }
    private static int longSubSequence(String s1,String s2){
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j])) + 1;
            }
        }
        return dp[s1.length()][s2.length()];
    }
}