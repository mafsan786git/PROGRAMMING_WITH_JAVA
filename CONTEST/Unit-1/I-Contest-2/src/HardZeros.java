import java.util.Scanner;

public class HardZeros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(0 < t--)
        {
            int n,m;
            n = sc.nextInt();
            m = sc.nextInt();
            if((n-m) > 1 || (n*2+2) < m)
                System.out.println(-1);
            else
            {
                StringBuilder str = new StringBuilder();
                if(m > n && (n*2+2) >= m)
                {
                    int TwoC = m-(n+1);
                    int rem = n-TwoC;
                    while(0<TwoC--)
                        str.append("110");
                    while (0 < rem--)
                        str.append("10");
                    if(rem == -1)
                        str.append("1");
                    else{
                        str.delete(str.length()-1,str.length());
                    }
//                    System.out.println(rem + " "+ TwoC);
                }else if (n > m){
                    while(0 < m--)
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

