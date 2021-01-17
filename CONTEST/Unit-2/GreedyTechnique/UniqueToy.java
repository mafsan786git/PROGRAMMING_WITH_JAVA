import java.io.*;
import java.util.*;

public class UniqueToy {
    static Integer[] StringToInt(StringTokenizer input){
        Integer[] arr = new Integer[input.countTokens()];
        int i=0;
        while(input.hasMoreTokens())
            arr[i++] = Integer.parseInt(input.nextToken());
        return arr;
        // Stack<Integer> st = new Stack<>();
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(input.nextToken());
        int m = Integer.parseInt(input.nextToken());
        Integer[] type = new Integer[n];
        input = new StringTokenizer(br.readLine());
        type = StringToInt(input);
        HashSet<Integer> set = new HashSet<>();
        for(Integer val : type)
            set.add(val);
        ArrayList<Integer> outPut = new ArrayList<>();
        int i = 1;
        while(m>0){
            if(set.contains(i))
            {   i++; 
                continue;
            }
            if(m >= i){
                outPut.add(i);
                m -= i;
                i++;
            }else
                break;
        }
        System.out.println(outPut.size());
        for(Integer val : outPut)
            System.out.print(val + " ");
        System.out.println();

    }
    
}
