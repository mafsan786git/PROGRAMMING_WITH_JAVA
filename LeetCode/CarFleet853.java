import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class CarFleet853 {
    public static void main(String[] args) {
        int value = countNumberOfCarFleet(100,new int[]{0,2,4},new int[]{4,2,1});
        System.out.println(value);
    }

    private static int countNumberOfCarFleet(int target,int[] position,int[] speed){
        int[][] pairOfCar = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            pairOfCar[i][0] = position[i];
            pairOfCar[i][1] = speed[i];
        }
        Arrays.sort(pairOfCar, Comparator.comparingInt(o -> o[0]));
        Stack<Double> fleet = new Stack<>();
        for (int i = pairOfCar.length -1 ; i >=0;i--){
            double currentTime = (double) (target-pairOfCar[i][0])/pairOfCar[i][1];
            if (!fleet.isEmpty() && currentTime <= fleet.peek()){
                continue;
            }else
                fleet.push(currentTime);
        }
        return fleet.size();
    }
}

