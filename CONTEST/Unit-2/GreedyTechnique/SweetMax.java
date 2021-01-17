import java.io.*;
import java.util.*;
/*
PROBLEM STATEMENT----------
    You have N sweets, each sweet has a sweetness and an expiry time(best before time). You cannot eat that sweet after expiry time or you will die. You can only eat 1 sweet per 1 unit of time.
    You want to eat sweets, such that you can have maximum sweetness.
INPUT FORMATE--------------
    First-line contains T, no of test cases.
    The first line of each test case contains N and M.
    The second line of each test case contains, contains N space-separated integers, where the ith integer is the sweetness of ith sweet.
    The third line of each test case contains, contains N space-separated integers, where the ith integer is the expiry time of ith sweet.
CONSTRAINTS---------------
    1 <= T <= 10
    1 <= N,time[i],sweetness[i]<= 10^6
TIME COMPLEXITY-----------
    O(long(n) * n)


*/

public class SweetMax {
    static Integer[][] StringToInt(StringTokenizer input,Integer arr[][],int j){
        int i=0;
        while(input.hasMoreTokens())
            arr[i++][j] = Integer.parseInt(input.nextToken());
        return arr;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(input.nextToken());
        while(t-- > 0){
            input = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(input.nextToken());
            Integer[][] sweetTime = new Integer[n][2];
            input = new StringTokenizer(br.readLine());
            sweetTime = StringToInt(input, sweetTime, 1);
            input = new StringTokenizer(br.readLine());
            sweetTime = StringToInt(input, sweetTime, 0);

            Arrays.sort(sweetTime, new Comparator<Integer[]>(){
                public int compare(Integer[] a,Integer[] b){
                    if(a[0] != b[0])
                        return b[0] - a[0];
                    return b[0]-a[0];
                }
            });
            // for(Integer[] val : sweetTime)
            //     System.out.println(Arrays.toString(val));
            long totalSweet = 0;
            int timeCount = 0;
            Queue<Integer> queue = new PriorityQueue<>((a,b)-> b-a);
            for (int i = 0; i < sweetTime.length-1; i++) {
                if(sweetTime[i][0] != sweetTime[i+1][0])
                {
                    queue.add(sweetTime[i][1]);
                    timeCount = sweetTime[i][0] - sweetTime[i+1][0];
                    // System.out.println("queue ----- : " + queue);
                    // System.out.println("before while time ---- : " +timeCount);
                    while(!queue.isEmpty() && timeCount>0 )
                    {
                        totalSweet += queue.poll();
                        timeCount--;
                    }
                    timeCount=0;
                    // System.out.println("after while sweet ---- : " +totalSweet);

                }else
                    queue.add(sweetTime[i][1]);
                // System.out.println(queue);
            }
            timeCount = sweetTime[n-1][0] - 0;
            queue.add(sweetTime[n-1][1]);
            while(!queue.isEmpty() && timeCount>0 )
            {
                totalSweet += queue.poll();
                timeCount--;
            }
            System.out.println(totalSweet);

        
        }

        
    }
}
