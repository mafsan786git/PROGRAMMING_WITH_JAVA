import java.io.*;
import java.util.*;

/*
PROBLEM STATEMENT------
    Mr.Robot needs an encryption method, so Elliott was there to help him. At the same time, Richard wrote a paper on encryption. Elliott then started writing his algorithms with the help of paper from Richard but he needs your help in implementing. The algorithm is like this:
    Given an input string, the encrypted string will start with the middle character of the string and will be formed henceforth with the middle characters of the left and right substrings (of the middle character of the word) and so on. Take a look at the explanation of the sample test case for better understanding.
CONSTRAINTS-----
    1 <= T <= 10
    1 <= Length of the string <= 10000

*/


public class EncryptionEliot {
    static String Encryption(String str,int low,int high){
        if(low <= high){
            int mid = low + (high-low)/2;
            return str.charAt(mid) + Encryption(str, low, mid-1) + Encryption(str, mid+1, high);
        }
        return "";
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(input.nextToken());
        while(t-- > 0){
            input = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(input.nextToken());
            input = new StringTokenizer(br.readLine());
            String str = input.nextToken();
            System.out.println(Encryption(str,0,n-1));
        }
        
    }
    
}
