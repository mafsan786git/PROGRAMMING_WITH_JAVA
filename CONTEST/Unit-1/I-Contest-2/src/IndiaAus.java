import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IndiaAus {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int t = Integer.parseInt(input[0]);
        while(0 < t--){
            input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            if(n == m){
                if(n == 0)
                System.out.println(0);
                else
                    System.out.println(1);
            }else if(n < m)
            {
                int temp = m/(n+1);
                if(m%(n+1) != 0)
                    temp += 1;
                System.out.println(temp);
            }else{
                int temp = n/(m+1);
                if(n%(m+1) != 0)
                    temp += 1;
                System.out.println(temp);
            }
        }
    }
}
