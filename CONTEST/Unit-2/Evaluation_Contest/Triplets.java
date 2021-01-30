import java.io.*;
import java.util.*;
public class Triplets {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long k = sc.nextLong();
        int[] arr= new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int count = 0;
        // int i=0;j=n-1;
        // while(j-i >=2){

        // }
        System.out.println(count);
        sc.close();
    }
}
