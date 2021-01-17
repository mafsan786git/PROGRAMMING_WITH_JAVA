import java.io.*;
import java.util.ArrayList;

public class IsPrime {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Boolean> prime = new ArrayList<>();
        for (int i = 0; i < 1000001; i++) {
            prime.add(true);
        }
        prime.set(0,false);
        prime.set(1,false);
        for (int i = 2; i*i < 1000001; i++) {
            if(prime.get(i))
            {
                for (int j = i*i; j < 1000001; j += i) {
                    prime.set(j,false);
                }
            }
        }
        String[] str = br.readLine().split(" ");
        int t = Integer.parseInt(str[0]);
        while (0 < t--){
            str = br.readLine().split(" ");
            int n = Integer.parseInt(str[0]);
            if(prime.get(n))
                System.out.println("Yes");
            else
                System.out.println("No");
        }


    }
}
