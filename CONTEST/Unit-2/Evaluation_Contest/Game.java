import java.io.*;
import java.util.*;

public class Game {
    static int[] StringToInt(StringTokenizer input){
        int[] arr = new int[input.countTokens()];
        int i=0;
        while(input.hasMoreTokens())
            arr[i++] = Integer.parseInt(input.nextToken());
        return arr;
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long k = sc.nextLong();
        int[] guns= new int[n];
        
        for (int i = 0; i < guns.length; i++) {
            guns[i] = sc.nextInt();
        }
        Arrays.sort(guns);
        int count = 0;
        for (int i = guns.length-1;i>=0; i--) {
            if(k > 0){
                k -= guns[i];
                count++;
            }else
            {
                break;
            }
        }
        System.out.println(count);
        sc.close();
    }
    
}