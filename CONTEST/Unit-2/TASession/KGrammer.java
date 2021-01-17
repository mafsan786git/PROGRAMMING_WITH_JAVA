
import java.util.*;

public class KGrammer {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long num = sc.nextLong();
        long k = sc.nextLong();
        System.out.println(kthGrammer(num,k));
        sc.close();
    }
    private static int kthGrammer(long num,long k){
        if(num == 1)
            return 0;
        if(k <= Math.pow(2, num-1)/2)
        {
            return kthGrammer(num-1, k);
        }else{
            int c = kthGrammer(num-1, (long)(k - Math.pow(2, num-1)/2));
            return (c == 0) ? 1 : 0;
        }
    }
}
