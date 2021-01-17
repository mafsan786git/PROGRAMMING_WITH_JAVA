import java.io.*;
import java.util.*;
/***
 * 
 * 
 * Virat and Rohit don't like each other though they have many similarities. You are given 2 texts (strings) written by Virat and Rohit. Your task is to write a program that calculates the length of the longest similar characters in the text written by both.
If string written by Virat is “AGGTAB” and that by Rohit is “GXTXAYB”, then the longest set of similar characters is “GTAB”, which is of length 4.
Please note that the longest set of similar characters need not be continuous.

INPUT
    AEDFHR
    ABCDGH
ouput = 3

 */
public class SimilarText {
    public static int maxLen = 0;
    public static void MaxLength(int indexV,int indexR, String virat,String rohit,int ans){

        if(indexV == virat.length() || indexR == rohit.length())
        {
            maxLen = Math.max(maxLen, ans);
            return ;
        }
        // AGGTAB
        // GXTXAYB
        maxLen = Math.max(maxLen, ans);
        for (int i = indexV;i < virat.length(); i++) {
            for (int j = indexR; j < rohit.length(); j++) { 
                if(virat.charAt(i) != rohit.charAt(j))
                    continue;
                MaxLength(i+1, j+1, virat, rohit, ans+1);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());

        String virat = input.nextToken();
        input = new StringTokenizer(br.readLine());
        String rohit = input.nextToken();
        // int index = 0;
        // int count=0;
        // for (int i = 0; i < virat.length(); i++) {
        //     for (int j = index; j < rohit.length(); j++) {
        //         if(virat.charAt(i) == rohit.charAt(j)){
        //             index = j+1;
        //             count++;
        //             break;
        //         }
        //     }
        //     if(index == rohit.length())
        //         break;
        // }

        MaxLength(0, 0, virat, rohit, 0);
        System.out.println(maxLen);


    }
    
}
