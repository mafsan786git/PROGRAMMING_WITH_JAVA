import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
PROBLEM STATEMENT----------
    You are given two numbers nand k. The number p iscreated by concatenating the string n k times.
    we need to find thesuper digit ofthe integer p
    We define superdigit of an integer pusing the following rules:
        If p has only 1 digit, then itssuperdigit is 1.
        Otherwise, thesuperdigit of p is equal to thesuperdigit of the sum of the digits of p.
    Read the Sample input explanation for better understanding.
INPUT FORMAT-----------
    The first line contains two space-separated integers,n-a string representation of an integerand k-an integer, the times to concatenate nto make p.
CONSTRAINTS------
    1 <= n <= 10^100000
    1 <= k <=10^5

Sample Input 1 Explanation
    Here n = 148 and k = 3 ,so p = 148148148.
    super_digit(P) = super_digit(148148148) 
               = super_digit(1+4+8+1+4+8+1+4+8)
               = super_digit(39)
               = super_digit(3+9)
               = super_digit(12)
               = super_digit(1+2)
               = super_digit(3)
               = 3.
*/
public class FamousSum{
    static int SumString(String str,int low,int high){
        if(low == high)
            return str.charAt(high)-'0';
        int mid = low + (high-low)/2;
        int sum = SumString(str,low,mid) + SumString(str, mid+1, high);
        String s = sum + "";
        return SumString(s, 0,s.length()-1);
    }
    static long sumOfstringTimes(long num,int n){
        if(n==1)
            return num;
        return num + sumOfstringTimes(num, n-1);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        String str = input.nextToken();
        int n = Integer.parseInt(input.nextToken());
        int sumOfstring = SumString(str,0,str.length()-1);
        
        str = sumOfstring*n + "";
        sumOfstring  = SumString(str, 0, str.length()-1);
        System.out.println(sumOfstring);
        
    }
}