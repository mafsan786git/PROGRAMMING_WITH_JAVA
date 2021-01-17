import java.io.*;
import java.util.*;
/*
Description------
    Now that you have learnt about geometric progression in Masai School pre-course, we hope you remember about the sum of a geometric series:
    Assume, you are given
    S = 1 + (1/r) + (1/r^2) + (1/r^3) +... (1/r^n)
    You will be given two integers n and r
    Your task is to calculate the sum S by writing a recursive function
    Using iterative approach or formula to calculate the sum can lead to disqualification directly
Input Format---------
    First line of input contains space separated numbers n and r respectively
Constraints------
    n <= 1000
    r <= 10
Output-------
    Output till 4 places after the decimal. For instance, 12.1345 is a valid answer but 12.43138 is not. 12.0000 is also a valid answer

*/
public class GPSum {
    static double power(int base,int n){
        long temp = 1;
        long p = base;
        while(base>0)
        {
            if((base & 1) == 1)
                temp = temp * base;
            base = base>>1;
            p *= p;
        }
        return (double)temp;

    }
    static double GpSum(int n,int r){
        if(n == 0)
            return 1.0;

        return 1/Math.pow(r, n)+GpSum(n-1, r);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(input.nextToken());
        int r = Integer.parseInt(input.nextToken());
        double temp  = GpSum(n, r);
        System.out.println(String.format("%.4f", temp));
    }
    
}
