import java.io.*;
import java.util.*;

public class SumExist{
    static long[] StringToInt(StringTokenizer input){
        long[] arr = new long[input.countTokens()];
        int i=0;
        while(input.hasMoreTokens())
            arr[i++] = Long.parseLong(input.nextToken());
        return arr;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(input.nextToken());
        input = new StringTokenizer(br.readLine());
        long[] arr =  StringToInt(input);
        input = new StringTokenizer(br.readLine());
        long sum = Long.parseLong(input.nextToken());
        if(SubSetSum(arr,sum,0,new ArrayList<>()))
            System.out.println("yes");
        else
            System.out.println("no");

    }

    private static boolean SubSetSum(long[] arr, long sum,int index,ArrayList<Long> list) {
        if(index == arr.length)
        {
            long sumTemp = 0;
            for(Long val : list)
                sumTemp += val;
            if(sumTemp == sum)
                return true;
            return false;
        }

        list.add(arr[index]);
        boolean flag = SubSetSum(arr, sum, index+1, list);
        if(flag) return true;
        list.remove(list.size()-1);
        flag = SubSetSum(arr, sum, index+1, list);
        if(flag)
            return true;

        return false;
    }
}