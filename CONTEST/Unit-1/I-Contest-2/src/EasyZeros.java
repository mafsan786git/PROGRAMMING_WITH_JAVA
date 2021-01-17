import java.util.ArrayList;
import java.util.Scanner;

public class EasyZeros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(0 < t--)
        {
            int n,m;
            n = sc.nextInt();
            m = sc.nextInt();
            if(Math.abs(n-m) > 1)
                System.out.println(-1);
            else
            {
                StringBuilder str = new StringBuilder();
                if(m > n)
                {
                    while(0<n-- && 0 < m--)
                        str.append("10");
                    str.append("1");
                }else if (n > m){
                    while(0<n-- && 0 < m--)
                        str.append("01");
                    str.append("0");
                }else
                {
                    while(0<n--)
                        str.append("10");
                }
                System.out.println(str);
            }

        }
    }
}
