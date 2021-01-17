import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;


public class UniqueToys {
    public static void main(String[] arg) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        long money = Long.parseLong(input[1]);
        input = br.readLine().split(" ");
        HashSet<Long> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(Long.parseLong(input[i]));
        }
        ArrayList<Long> output = new ArrayList<>();
        System.out.println(set);
        long temp=1;
        while (money >= temp){
            if(!set.contains(temp))
            {
                output.add(temp);
                money -= temp;
            }
            temp++;
        }
        System.out.println(output.size());
        for (Long aLong : output) {
            System.out.print(aLong + " ");
        }

    }
}
