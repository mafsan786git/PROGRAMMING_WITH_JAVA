import java.util.*;
import java.io.*;
public class ValidPalindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(input.nextToken());
        while(t-- > 0)
        {
            input = new StringTokenizer(br.readLine());
            String str = input.nextToken().toString();
            // boolean minCost = validPalRecur(str,0,str.length()-1,0);
            boolean minCost = validPalWhile(str);
            bw.write(minCost + "\n");
        }

        br.close();
        bw.close();
    }

    private static boolean validPalRecur(String str,int left,int right,int count) {
        if(count > 1)
            return false;
        if(left >= right)
            return true;
        if(str.charAt(left) == str.charAt(right))
            return validPalRecur(str, left+1, right-1, count);
        else{
            return validPalRecur(str, left+1, right, count+1) | validPalRecur(str, left, right-1, count+1);   
        }
    }

    private static boolean validPalWhile(String str){
        int left = -1,right = str.length();
        while(++left < --right)
            if(str.charAt(left) != str.charAt(right))
                return isPalinDrome(str,left,right+1) || isPalinDrome(str,left-1,right);
        return true;

    }

    private static boolean isPalinDrome(String str, int left, int right) {
        while(++left < --right)
            if(str.charAt(left) != str.charAt(right))
                return false;
        return true;
    }


    
}
