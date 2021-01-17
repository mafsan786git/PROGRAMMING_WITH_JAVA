import java.io.*;
import java.util.ArrayList;
import java.util.Collections;


public class Triangle {
    boolean checkTri(long a,long b,long c){
        return (a + b) > c && (a + c) > b && (c + b) > a;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = br.readLine().split(" ");
        int t = Integer.parseInt(str[0]);
        while(0 < t--){
            str = br.readLine().split(" ");
            int n = Integer.parseInt(str[0]);
            str = br.readLine().split(" ");
            ArrayList<Long> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                arr.add(Long.parseLong(str[i]));
            }
            Collections.sort(arr);
            boolean flag = false;
            Triangle Obj = new Triangle();
            for (int i = 0; i < n-2; i++) {
                if(Obj.checkTri(arr.get(i),arr.get(i+1),arr.get(i+2)))
                {
                    flag = true;
                    break;
                }
            }
            if(flag)
                bw.write("Yes");
            else
                bw.write("No");
            bw.newLine();
            bw.flush();

        }
    }
}
