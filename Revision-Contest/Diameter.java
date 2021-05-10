import java.util.*;

public class Diameter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t--  > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }
            long mxDia = 0;
            long temp = 0;
            for (int i = 0; i < arr.length; i++) {
                if(arr[i] == 1){
                    temp++;
                    if(mxDia != 0){
                        mxDia += (temp+1)/2;
                    }
                    mxDia = Math.max(mxDia, temp);
                    temp = 0;
                }else{
                    temp +=2;
                }
            }
            System.out.println(mxDia);
        }
        sc.close();
    }
}
