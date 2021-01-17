import java.util.Scanner;

public class ReverseString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(0< t--)
        {
            String str = sc.nextLine();
            String arr[] = str.split(" ");
            for(String word:arr)
            {
                int l = word.length();
                for (int i = 0; i < l; i++) {
                    System.out.print(word.charAt(l-1-i));
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
