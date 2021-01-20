import java.io.*;
import java.util.*;
public class Factorial {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        // BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(input.nextToken());
        while(t-- > 0)
        {
            input = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(input.nextToken());
            factorialBigNumber(num);
            
        }
        br.close();
        bw.close();
    }

    private static void factorialBigNumber(int num) {
        int[] result = new int[500];

        result[0] = 1;
        int size = 1;
        for (int i = 2; i <= num; i++) {
            size = findFactorialSingleNum(result,size,i);
        }

        for (int i = size-1; i >=0; i--) {
            System.out.print(result[i]);
        }
        System.out.println();
    }

    private static int findFactorialSingleNum(int[] result, int size, int i) {
        int carry = 0;

        for (int j = 0; j < size; j++) {
            int product = result[j]*i + carry;
            result[j] = product%10;
            carry = product/10;
        }
        while(carry != 0)
        {
            result[size++] = carry%10;
            carry /= 10;
        }
        return size;
    }
    
}
