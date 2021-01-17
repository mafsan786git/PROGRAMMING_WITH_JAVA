import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t>0){
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            if(s1.length() == s2.length())
            {
                char s1Array[] = s1.toCharArray();
                Arrays.sort(s1Array);
                char s2Array[] = s2.toCharArray();
                Arrays.sort(s2Array);
                System.out.println(s1Array);
                if(Arrays.equals(s1Array,s2Array))
                    System.out.println("True");
                else
                    System.out.println("False");
            }else
                System.out.println("False");
            t--;
        }
    }
}
