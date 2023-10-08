
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class ResturantCustomers {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        TreeMap<Integer,Integer> freq = new TreeMap<>();
        for(int i = 0 ; i< size;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            freq.put(Integer.parseInt(st.nextToken()), 1);
            freq.put(Integer.parseInt(st.nextToken()), -1);
        }
        int maxCustomer = 0;
        int count = 0;
        for ( Integer values : freq.values()) {
            count += values;
            maxCustomer = Math.max(maxCustomer, count);
        }
        System.out.println(maxCustomer);
    }
}
