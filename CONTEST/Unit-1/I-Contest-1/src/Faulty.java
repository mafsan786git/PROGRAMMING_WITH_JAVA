import java.util.Scanner;

public class Faulty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            int n = sc.nextInt();
            sc.nextLine();
            int x = 0,y=0;
            String str = sc.nextLine();
            for (int i = 0; i < n; i++) {
                char c = str.charAt(i);
                if(c == 'R')
                    x +=1;
                else if (c == 'U')
                    y +=1;
                else if (c == 'L')
                    x -=1;
                else
                    y -=1;
            }
            if(x ==0 && y==0)
                System.out.println("Yes");
            else
                System.out.println("No");
            t--;
        }
    }
}
