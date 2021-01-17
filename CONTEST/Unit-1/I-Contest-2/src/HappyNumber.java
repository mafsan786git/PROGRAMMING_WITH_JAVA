import java.util.HashSet;
import java.util.Scanner;



public class HappyNumber {
    public static void main(String []arg){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(0 < t--){
            long num = sc.nextInt();
            long temp;
            HashSet<Long> set = new HashSet<>();
            set.add(num);
            boolean flag = true;
            while(num > 1){
                temp = num;
                num = 0;
                while(temp > 0)
                {
                    long mul = temp%10;
                    num += mul*mul;
                    temp = temp/10;
//                    System.out.print("w2 ");
                }
//                System.out.println();
                if(set.contains(num))
                {
                    flag = false;
//                    System.out.println("if break...");
                    break;
                }
                set.add(num);
//                System.out.println("w1");
            }
            if(flag)
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
