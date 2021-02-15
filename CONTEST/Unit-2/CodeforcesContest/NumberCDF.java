import java.util.Scanner;

public class NumberCDF {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int n = sc.nextInt();
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                a = a*10 + j;
                if(a%b == 0){
                    count++;
                    break;
                }
                a = a/10;
            }
            if(i == count)
                break;
        }
        if(a%b == 0 && count == n)
            System.out.println(a);
        else
            System.out.println(-1);
            sc.close();
    }
}
