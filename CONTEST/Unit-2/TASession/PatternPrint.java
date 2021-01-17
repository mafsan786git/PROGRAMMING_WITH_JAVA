import java.util.Scanner;

public class PatternPrint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // int zeros = (2*n-2)/2;
        // int countN = 1,length = (2*n-2)+1;
        /*for (int i = 0; i < n; i++) {
            String str = "";
            for (int j = 0; j < zeros*2+1; j++) {
                if(j == zeros)
                {
                    for (int j2 = 0; j2 < countN+(countN-1);j2++) {
                        if(j2%2 == 0)
                            str += n;
                        else
                            str += '0';
                    }
                    countN++;
                    
                }else{
                    str += '0';
                }
                
            }
            zeros--;
            System.out.println(str);
        }*/

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-i-1; j++) {
                
                System.out.print("*");
            }
            for (int j = 0; j < i; j++) {
                    System.out.print(n + "*");
            }
            System.out.print(n);
            for (int j = 0; j < n-i-1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        sc.close();
        
    }
    
}
