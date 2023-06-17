

import java.util.Arrays;

public class Main {
    public static void main(String[] args){

        TwoSum  twoSumObject = new TwoSum();
        int[] answer = twoSumObject.twoSum(new int[]{1,-3,3,0}, 0);
        System.out.println("Printing answer : ");
        System.out.println(Arrays.toString(answer));
    }
}
