import java.util.Scanner;

public class GroupReverse {
    public static void main(String arg[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(0 < t--)
        {
            int k = sc.nextInt();
            sc.nextLine();
            String str = sc.nextLine();
            int n = str.length();

            String result = "";
            if(k>n)
            {
                for (int i = 0; i < n; i++) {
                    System.out.print(str.charAt(n-1-i));
                }
            }else {
                int turn=k;
                int c=turn;
                int m = n;
                for (int i = 0; i < n && k<=n; i++) {
                    if(turn%k == 0 && i<turn && (turn/k)%2 !=0) {
                        if (turn <= n)
                        {

                            System.out.print(str.charAt(c-1));
//                            System.out.print(c);
                            c--;
                        }
                        else {

                            System.out.print(str.charAt(m - 1));
                            m--;
                        }
                    } else
                    {
                        System.out.print(str.charAt(i));
                        turn +=2;
                        c = turn;
                    }
                }
            }


            System.out.println();
        }
    }
}
