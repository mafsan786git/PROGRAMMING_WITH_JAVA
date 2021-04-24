
import java.util.*;
import java.io.*;

public class LongSubPalin{
 public static void main(String[] arg) throws IOException{
   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   StringTokenizer input = new StringTokenizer(br.readLine());
   String str = input.nextToken();
   int n = str.length();
   int maxLen = 1;
   for(int i=0;i<n;i++){
     for(int j=i;j<n;j++){
       if(isPalindrome(str,i,j) && maxLen < (j-i+1)){
           maxLen = j-i+1;
       }
     }
   }
   System.out.println(maxLen);
   
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