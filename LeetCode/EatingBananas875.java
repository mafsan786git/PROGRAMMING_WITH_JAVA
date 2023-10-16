import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class EatingBananas875 {
    public static void main(String[] args) {
        int answer = minimumSpeed(new int[]{30,11,23,4,20},6);
        System.out.println(answer);
    }

    public static int minimumSpeed(int[] piles,int h){
        int min = 1;
        int max = 0;
        for (int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }
        int minSpeed = max;
        while(min <= max){
            int mid = min + (max - min)/2;
            int eatingHours = calculateTotalEatingHours(piles,mid);
            if(h > eatingHours || h == eatingHours){
                max = mid-1;
                minSpeed = mid;
            }else if(h < eatingHours){
                min = mid+1;
            }
        }
        return minSpeed;
    }

    public static int calculateTotalEatingHours(int[] piles,int speed){
        int totalHours = 0;
        for (int values : piles) {
            totalHours += Math.ceil((double)values/speed);
        }
        return totalHours;
    }
}
