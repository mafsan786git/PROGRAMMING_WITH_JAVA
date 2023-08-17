public class Palindrome125 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("11"));
    }

    public static boolean isPalindrome(String s) {
        int firstIndex  = 0;
        int lastIndex = s.length()-1;
        while(firstIndex <= lastIndex){
            if(!isValidChar(s.charAt(firstIndex))){
                firstIndex++;
                continue;
            }
            if(!isValidChar(s.charAt(lastIndex))){
                lastIndex--;
                continue;
            }
            if(toLower(s.charAt(firstIndex)) == toLower(s.charAt(lastIndex))){
                firstIndex++;
                lastIndex--;
            }else{
                return false;
            }
        }
        return true;
    }

    public static boolean isValidChar(char alpha){
        return isUpper(alpha) || isLower(alpha) || isDigit(alpha);
    }

    public static boolean isDigit(char alpha){
        return (alpha >= 48 && alpha <= 57);
    }

    public static boolean isUpper(char alpha){
        return (alpha >= 65 && alpha <= 90);
    }

    public static boolean isLower(char alpha){
        return (alpha >= 97 && alpha <= 122);
    }

    public static char toLower(char alpha){
        if(isUpper(alpha)){
            return (char)(alpha+32);
        }
        return alpha;
    }
}
