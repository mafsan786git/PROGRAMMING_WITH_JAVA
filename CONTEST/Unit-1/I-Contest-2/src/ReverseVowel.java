import java.util.Arrays;
import java.util.Scanner;

public class ReverseVowel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(0 < t--)
        {
            String str = sc.nextLine();
            String vow = "";
            int []arr = new int[str.length()];
            int j=0;
            for (int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'o' || str.charAt(i) == 'i' || str.charAt(i) == 'u') {
                    vow = str.charAt(i) + vow;
                    arr[j++] = i;
                }
            }
            String s[] = str.split("");
            String v = "";
            for (int i = 0; i < j; i++) {
                v = v +vow.charAt(i);
                s[arr[i]] = v;
                v = "";
            }
            for(String word : s)
                System.out.print(word);
            System.out.println();
        }
    }
}
