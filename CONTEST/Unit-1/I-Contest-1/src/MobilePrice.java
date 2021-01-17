import java.util.Scanner;

public class MobilePrice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int n = sc.nextInt();
            int [] tech = new int[n];
            int [] price = new int[n];
            for (int i = 0; i < n; i++)
                tech[i] = sc.nextInt();
            for (int i=0;i<n;i++)
                price[i] = sc.nextInt();
            boolean flag = false;
            for (int i = 0; i < n; i++) {
                int tec = tech[i],p = price[i];
                for (int j = i+1; j < n; j++) {
                    if((tec>tech[j] && p<price[j]) || (tec<tech[j] && p>price[j])) {
                        flag = true;
                        break;
                    }
                }
            }

            if(flag)
                System.out.println("Suresh Wins");
            else
                System.out.println("Mukesh Wins");
            t--;
        }
    }
}
