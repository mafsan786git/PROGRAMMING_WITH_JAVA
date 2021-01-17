
import java.util.*;

/*
PROBLEM STATEMENT----
    Given an integer N , you have to find the natural logarithmic value of given integer's factorial i.e., ln(n!).
    You have to print the result up to 4 digits after the decimal point.
    Note: You are not allowed to use log built-in function to calculate directly ln(n!) but you can use it anywhere else to know the logarithmic value of a particular integer. Also, you can't use any direct formula or perform the task iteratively - Try achieving the output recursively
Input format--------------
    Single line consists an integer N
Constraints---------
    1 <= N <= 50
*/
public class LogOfFact {

    static double LogFact(int n){
        if(n == 1)
            return Math.log(n);
        return Math.log(n) + LogFact(n-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(String.format("%.4f", LogFact(n)));
        sc.close();
    }
    
}
