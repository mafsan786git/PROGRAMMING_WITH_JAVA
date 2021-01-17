import java.util.Scanner;

public class Group {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            int n = sc.nextInt();
            String str = "1";
            for (int i = 2; i <= n; i++) {
                int count = 1;
                char c = str.charAt(0);
                String str1 = "";
                for (int j = 0; j < str.length()-1; j++) {
                    if (str.charAt(j) == str.charAt(j+1))
                        count++;
                    else
                    {
                        str1 = str1+count+c;
                        count=1;
                        c = str.charAt(j+1);
                    }
//                    System.out.println(str1);
                }
                str1 = str1+count+c;
                str = str1;
                
            }
            System.out.println(str);
            t--;
        }
    }
}
