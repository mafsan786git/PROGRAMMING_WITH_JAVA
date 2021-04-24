import java.util.*;
import java.io.*;
/**
 * A number N has to be changed to 1.
    The operations that can be used are listed below:
    - Replace N with N/2 if n is divisible by 2
    - Replace N with 2N/3 if n is divisible by 3
    - Replace N with 4N/5 if n is divisible by 5
 */
public class CountStep {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(input.nextToken());
        while(t-- > 0){
            input = new StringTokenizer(br.readLine());
            long number = Long.parseLong(input.nextToken());
            long count = 0L;
            boolean flag = true;
            while(number != 1){
                if(number%2 == 0){
                    number = number/2;
                    count++;
                }else if(number%3 == 0){
                    number = 2*(number)/3;
                    count++;
                }else if(number%5 == 0){
                    number = 4*(number)/5;
                    count++;
                }else{
                    flag = false;
                    break;
                }
            }
            if(flag)
                System.out.println(count);
            else
                System.out.println(-1);
        }
    }
}
