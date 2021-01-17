import java.util.Scanner;

public class MaxScore {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            int n,m;
            n = sc.nextInt();
            m = sc.nextInt();
            int sum = 0;
            while(n>0)
            {
                sum = sum + sc.nextInt();
                n--;
            }
            if(sum<=m)
                System.out.println(sum);
            else
                System.out.println(m);
            t--;
        }
    }
}
