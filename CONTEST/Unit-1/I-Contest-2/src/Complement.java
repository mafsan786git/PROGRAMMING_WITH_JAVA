import java.io.*;

public class Complement {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int t = Integer.parseInt(str[0]);
        while (0 < t--)
        {
            str = br.readLine().split(" ");
            long num = Long.parseLong(str[0]);
            long bit = (long) (Math.floor(Math.log(num)/Math.log(2))+1);
//            System.out.println(bit);
            if((num & (num-1)) == 0){
                System.out.println(num-1);
            }else
            {
                long temp = ((1<<bit)-1)^num;
                System.out.println(temp);
            }

        }
    }
}
