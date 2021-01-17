import java.io.*;
import java.util.*;

public class OddSubsets {
    static int[] StringToInt(StringTokenizer input){
        int[] arr = new int[input.countTokens()];
        int i=0;
        while(input.hasMoreTokens())
            arr[i++] = Integer.parseInt(input.nextToken());
        return arr;
    }
    static int count=0;
    static void SubSetOdd(int[] arr,int index,ArrayList<Integer> list)
    {
        if(index == arr.length){
            int sum = 0;
            for(Integer val : list)
                sum += val;
            if(sum%2 != 0)
                count++;
            return ;
        }
        list.add(arr[index]);
        SubSetOdd(arr, index+1, list);
        list.remove(list.size()-1);
        SubSetOdd(arr, index+1, list);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(input.nextToken());
        input = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        arr = StringToInt(input);
        SubSetOdd(arr, 0, new ArrayList<>());
        System.out.println(count);
    }
    
}
