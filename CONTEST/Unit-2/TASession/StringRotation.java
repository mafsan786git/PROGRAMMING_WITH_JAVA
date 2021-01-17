import java.io.*;
import java.util.StringTokenizer;

public class StringRotation {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        StringBuilder A = new StringBuilder(input.nextToken());
        input = new StringTokenizer(br.readLine());
        StringBuilder B = new StringBuilder(input.nextToken());
        int count = 0;
        boolean flag = false;
        // String str = "";
        while(count < A.length()-1){
            String temp =  "" + A.charAt(0);
            A.deleteCharAt(0);
            System.out.println(A);
            A.append(temp);
            // A.
            System.out.println(A.compareTo(B));
            System.out.println(A);
            count++;
            if(A == B)
            {
                flag = true;
                break;
            }
        }
        if(flag)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
    
}
