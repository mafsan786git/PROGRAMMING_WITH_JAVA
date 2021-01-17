import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ElectricPole {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int t = Integer.parseInt(input[0]);
        while(0 < t--){
            input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            input = br.readLine().split(" ");
            int[] arr = new int[1001];
            for (int i = 0; i < n; i++) {
                arr[Integer.parseInt(input[i])]++;
            }
            int curr_count = 0;
            int total_count = 0;
            for (int i = 1; i <= 1000; i++) {
                total_count += Math.min(arr[i],curr_count);
                curr_count = Math.max(arr[i],curr_count);
            }
            System.out.println(total_count*5);
        }
    }
}
