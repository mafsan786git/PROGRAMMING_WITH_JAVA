import java.util.Arrays;

public class Anagram242 {
    public static void main(String[] args) {
        isAnagram("rat","car");
    }

    public static boolean isAnagram(String s, String t) {
        int[] totalCharacters = new int[256];
        for (int index = 0; index < s.length(); index++) {
            totalCharacters[s.charAt(index)]++;
        }
        for (int index = 0; index < t.length(); index++) {
            totalCharacters[t.charAt(index)]--;
        }
        for (int index = 0; index < totalCharacters.length; index++) {
            if (totalCharacters[index] != 0) {
                return false;
            }
        }
        return true;

    }
}