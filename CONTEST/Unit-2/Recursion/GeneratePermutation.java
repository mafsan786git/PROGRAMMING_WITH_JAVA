import java.util.*;
import java.io.*;

public class GeneratePermutation {
    static int[] StringToInt(StringTokenizer input)
    { 
        int[] arr = new int[input.countTokens()];
        int i=0;
        while(input.hasMoreTokens())
            arr[i++] = Integer.parseInt(input.nextToken());
        return arr;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        // int n = Integer.parseInt(input.nextToken());
        input = new StringTokenizer(br.readLine());
        int[] arr = StringToInt(input);
        List<String> list= new ArrayList<>();
        Permutation(arr,0,0,list);
        Collections.sort(list);
        for(String str : list)
            System.out.println(str);
        
        // System.out.println();

    }

    private static void Permutation(int[] arr, int index, int temp,List<String> list) {
        if(index == arr.length)
        {
            String str = "";
            for(Integer val:arr)
                str = str + val + " ";
            list.add(str);
            return ;
        }
        if(temp == arr.length)
            return ;
        
        Swap(arr,index,temp);
        Permutation(arr, index+1, index+1,list);
        Swap(arr,index,temp);
        Permutation(arr, index, temp+1,list);
    }

    private static void Swap(int[] arr, int index, int temp) {
        int val = arr[index];
        arr[index] = arr[temp];
        arr[temp] = val;
    }
    
}
