import java.util.HashSet;
import java.util.Scanner;

public class TileOfTogether {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        long small = sc.nextLong();
        long large = sc.nextLong();
        long temp = Math.max(small, large);
        small = Math.min(small, large);
        large = temp;
        HashSet<Long> set = new HashSet<>();
        set.add(large);
        while(small < large){
            if(set.contains(small)){
                break;
            }

            temp = small;
            long sum = 0;
            while(temp > 0){
                sum += temp%10;
                temp /= 10;
            }
            small = sum+small;
            large = pathSum(large, set);
            set.add(large);
        }
        if(set.contains(small)){
            System.out.println(small);
        }else{
            System.out.println(-1);
        }
        sc.close();
    }

    public static long pathSum(long num,HashSet<Long> set){
        long temp = num;
        long sum = 0;
        while(temp > 0){
            sum += temp%10;
            temp /= 10;
        }
        return (sum+num);
    }
    
}
