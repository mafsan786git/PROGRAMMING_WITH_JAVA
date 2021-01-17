import java.util.Scanner;

public class ExcelNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(0 < t--)
        {
            String str = sc.nextLine();
            int len = str.length();
            long result = 0;
            for (int i = 0; i <len; i++) {
                result += Math.pow(26,len-1-i)*(str.charAt(i)-'A'+1);
            }
            System.out.println(result);
        }
    }
}
