import java.util.*;
import java.io.*;
/*
PROBLEM STATEMENT-------------
    There were N minions who were marching in a line. Due to the attack by the witch, M of them died. So the Minions which are alive now decided to stay together.
    Your task is to find the minimum total movement minions should do so that all living minions are adjacent to each other.
    You are given a string of size N, where L means minion is still alive and D meaning minion is dead.
    As total movements required can be very largeprint answer modulo10^9+7.
INPUT--------------
    The first line of the test case contains T, no of test cases.
    The first line of each test case contains a single integer N, no of total minions.
    Second-lineof each test casecontains an N sized string containing 'L' and 'D'.
CONSTRAINT-------
1 <= N <= 10^6
Time Complexity O(N*N):
    because here checking for every possible L;
Inplace
*/

public class MovementMinionins {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(input.nextToken());
        long mod = (long)1e9+7;
        while(t-- > 0){
            input = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(input.nextToken());
            input = new StringTokenizer(br.readLine());
            String str = input.nextToken();
            int mid = 0;
            int countD = 0;
            int countL = 0;
            long leftMov = 0,rightMov = 0;
            long mn = Integer.MAX_VALUE;
    
            for (mid = 0; mid < str.length(); mid++){
                leftMov  = 0;rightMov = 0;countD=0;countL=0;
                if(str.charAt(mid) == 'D')
                    continue;
                for (int i = mid-1; i>=0;i--) {
                    if(str.charAt(i) == 'D')
                    {
                        leftMov += (countL*countD)%mod;
                        leftMov %=mod;countL=0;countD++;
                    }else
                    {
                        countL++;
                    }  
                }
                if(str.charAt(0) == 'L'){
                    leftMov += (countL*countD)%mod;
                }
                countD = 0;countL = 0;
                for (int i = mid+1; i<n; i++) {
                    if(str.charAt(i) == 'D')
                    {
                        rightMov += (countL*countD)%mod;
                        rightMov %= mod;countL=0;countD++;
                    }else{
                        countL++;
                    }    
                }
                if(str.charAt(n-1) == 'L')
                {
                    rightMov += (countD*countL)%mod;
                }
                mn = Math.min(mn, (rightMov + leftMov)%mod);
            }
            if(mn == Integer.MAX_VALUE)
                mn = 0;
            System.out.println(mn);
        }

    }
    
}