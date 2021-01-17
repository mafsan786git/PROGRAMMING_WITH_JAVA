import java.util.Scanner;

public class Symmetry {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(0 < t--)
        {
            int n = sc.nextInt();
            sc.nextLine();
            String[] mat = new String[n];
            for (int j = 0; j < n; j++)
                mat[j] = sc.nextLine();

            boolean horizon = true;
            boolean vertical = true;
            for (int i = 0; i <= n/2; i++) {
                for (int j = 0; j < n; j++) {
                    if(mat[i].charAt(j) != mat[n-1-i].charAt(j)) {
                        horizon = false;
                        break;
                    }
                }
            }
            for (int j = 0; j <= n/2; j++) {
                for (int i = 0; i < n; i++) {
                    if(mat[i].charAt(j) != mat[i].charAt(n-1-j)) {
                        vertical = false;
                        break;
                    }
                }
            }
            if(horizon && vertical)
                System.out.println("BOTH");
            else if(horizon)
                System.out.println("HORIZONTAL");
            else if(vertical)
                System.out.println("VERTICAL");
            else
                System.out.println("NO");
        }
    }
}
