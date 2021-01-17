import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("masaischool");
        reverseString(str,0);
        System.out.println(str.toString());
        reverseNumber(10);
        System.out.println();
        char[] s = new char[]{'a','b','c','d'};
        reverseChar(s, 0);
        System.out.println(Arrays.toString(s));

    }

    private static void reverseString(StringBuilder str, int i) {
        if(i == str.length()/2)
            return ;
        char temp = str.charAt(i);
        str.setCharAt(i, str.charAt(str.length()-i-1));
        str.setCharAt(str.length()-1-i,temp);
        reverseString(str, i + 1);
         
    }
    private static void reverseNumber(int n){
        if(n==0)
            return ;
        System.out.print(n + " ");
        reverseNumber(n-1);
        
    }
    private static void reverseChar(char[] s,int index){
        if(index == s.length)
            return ;
        char c = s[index];
        reverseChar(s, index+1);
        s[s.length-index-1] = c;
        
    }
    
}
