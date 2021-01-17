import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CarFuel {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int t = Integer.parseInt(input[0]);
        while (0 < t--) {
            input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            input = br.readLine().split(" ");
            int[] coor = new int[n];
            for (int i = 0; i < n; i++) {
                coor[i] = Integer.parseInt(input[i]);
            }
            input = br.readLine().split(" ");
            int[] fuel = new int[n];
            for (int i = 0; i < n; i++) {
                fuel[i] = Integer.parseInt(input[i]);
            }
            int d = 100000,count=0;
            for (int i = n-1; i >= 0 ; i--) {
                if(d-coor[i] <= fuel[i])
                {
                    d = coor[i];count++;
                }else
                    d = d-fuel[i];
            }
            System.out.println(count);
        }
    }
}
