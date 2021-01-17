import java.io.*;
import java.util.*;

public class SubSetOfArray {
    static int[] StringToInt(StringTokenizer input){
        int[] arr = new int[input.countTokens()];
        int i=0;
        while(input.hasMoreTokens())
            arr[i++] = Integer.parseInt(input.nextToken());
        return arr;
    }
    // /* Without using For loop  */
    // public static void SubSets(int n,List<Integer> list,int index){
    //     System.out.println(list);
    //     if(index > n)
    //         return ;
    //     else{
    //         list.add(index);
    //         SubSets(n, list, index+1);
    //         list.remove(list.size()-1);
    //         SubSets(n, list, index+1);
    //     }
    // }
    
    /**Using For Loop */
    public static void SubSets(int[] arr,List<Integer> list,int index){
        System.out.println(list);
        for (int i = index; i < arr.length; i++) {
            list.add(arr[i]);
            SubSets(arr, list, i+1);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int[] arr = new int[input.countTokens()];
        arr = StringToInt(input);
        SubSets(arr,new ArrayList<>(), 0);

    }
    
}
