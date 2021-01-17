import java.util.ArrayList;
import java.util.Scanner;

public class ZerosAtEnd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(0 < t--)
        {
            int n = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            int count = 0;
            for (int i = 0; i < n; i++) {
                int input = sc.nextInt();
                if(input == 0)
                    count++;
                else
                    arr.add(input);
            }
            for(int out:arr)
                System.out.print(out + " ");
            while(0 < count--)
                System.out.print(0 + " ");
            System.out.println();
        }
    }

}
