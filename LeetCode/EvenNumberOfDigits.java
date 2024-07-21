

public class EvenNumberOfDigits {
    public static void main(String[] arg){
        System.out.println(findNumbers(new int[]{555,23,482,1771}));
    }

    public static int findNumbers(int[] nums) {
        int evenNumberOfDigits = 0;
        for(int index=0;index < nums.length; index++){
            int numberOfDigit = countDigits(nums[index]);
            System.out.println("numberOfDigit : " + numberOfDigit);
            if(numberOfDigit%2 == 0)
                evenNumberOfDigits++;
        }
        return evenNumberOfDigits;
    }
    
    private static int countDigits(int number){
        int numberOfDigit = 0;
        while(number > 0){
            number = number/10;
            numberOfDigit++;
        }
        return numberOfDigit;
    }
}