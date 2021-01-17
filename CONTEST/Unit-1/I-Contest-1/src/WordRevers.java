import java.util.Scanner;

public class WordRevers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String s[] = str.split(" ");
        for (int i = 0; i < s.length; i++) {
            System.out.print(s[s.length-1-i]+" ");
        }

    }
}
