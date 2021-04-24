import java.util.*;
import java.io.*;

/**
 * Given an array 'A' consisting of 'n' integers, find the maximum value of the following expression:
    |Ai - Aj| + |i - j|
 */
public class MaxDiffSum {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        // String str = "";
        
        int t = Integer.parseInt(input.nextToken());
        while(t-- > 0){
            input = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(input.nextToken());
            int[] arr = new int[n];
            input = new StringTokenizer(br.readLine());
            int idx = 0;
            while(input.hasMoreTokens()){
                arr[idx++] = Integer.parseInt(input.nextToken());
            }
            int[] sumArr  = new int[n];
            int[] difArr = new int[n];
            for (int i = 0; i < sumArr.length; i++) {
                sumArr[i] = arr[i] + i;
                difArr[i] = arr[i] - i;
            }

            int mxVal = sumArr[0];
            int mnVal = sumArr[0];
            for (int i = 0; i < sumArr.length; i++) {
                if(mxVal < sumArr[i])
                    mxVal = sumArr[i];
                if(mnVal > sumArr[i])
                    mnVal = sumArr[i];
            }
            int ans = mxVal - mnVal;
            mxVal = difArr[0];
            mnVal = difArr[0];
            for (int i = 0; i < sumArr.length; i++) {
                if(mxVal < difArr[i])
                    mxVal = difArr[i];
                if(mnVal > difArr[i])
                    mnVal = difArr[i];
            }
            ans = Math.max(ans, mxVal-mnVal);
            System.out.println(ans);

        }
    }
}