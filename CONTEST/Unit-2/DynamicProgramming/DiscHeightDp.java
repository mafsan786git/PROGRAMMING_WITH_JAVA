import java.io.*;
import java.util.*;
public class DiscHeightDp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(input.nextToken());
        while(t-- > 0)
        {
            input = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(input.nextToken());
            ArrayList<ArrayList<Long>> disc = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                input = new StringTokenizer(br.readLine());
                disc.add(new ArrayList<>());
                disc.get(i).add(Long.parseLong(input.nextToken()));
                disc.get(i).add(Long.parseLong(input.nextToken()));
            }
            Collections.sort(disc,new Comparator<ArrayList<Long>>(){
                public int compare(ArrayList<Long> a,ArrayList<Long> b){
                    return a.get(0).compareTo(b.get(0));
                }
            });
            // System.out.println();
            // for(ArrayList<Long> arr : disc){
            //     System.out.println(arr.get(0) + " " + arr.get(1));
            // }
            // System.out.println();
            ArrayList<Long> dp = new ArrayList<>();
            dp.add(disc.get(0).get(1));
            for (int i = 1; i < n; i++) {
                dp.add(disc.get(i).get(1));
                for (int j = 0; j < i; j++) {
                    
                    if(disc.get(j).get(0) < disc.get(i).get(0) && disc.get(j).get(1) < disc.get(i).get(1))
                    {
                        long temp = Math.max(dp.get(i) ,dp.get(j) +  disc.get(i).get(1));
                        dp.set(i,temp);
                    }
                }
            }
            long sum = Long.MIN_VALUE;
            for(Long val : dp)
            {
                sum = Math.max(sum, val);
            }
            System.out.println(sum);
            
        }
    }
    
}
