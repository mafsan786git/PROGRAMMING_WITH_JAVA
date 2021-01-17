import java.util.Scanner;

public class Nick {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(0 < t--){
            long n = sc.nextLong();
            if(n%10 !=0 && n!=1)
                System.out.println("No");
            else
            {
                long temp = n;
                while(temp%10 == 0){
                    temp /= 10;
                }
                if(temp%2 == 0)
                {
                    System.out.println(temp);
                    while(n>1)
                    {
                        if(n%20 == 0)
                            n = n/20;
                        else if(n%10 == 0)
                            n = n/10;
                        else break;
                        System.out.println(n);
                    }
                }else{
                    while(n>1)
                    {
                       if(n%10 == 0)
                            n = n/10;
                        else break;
                    }
                }
                if(n == 1)
                    System.out.println("Yes");
                else
                    System.out.println("No");
            }
        }
    }
}
