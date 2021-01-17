import java.io.*;
import java.util.*;

public class PermutationOfArray {
    static int[] StringToInt(StringTokenizer input){
        int[] arr = new int[input.countTokens()];
        int i=0;
        while(input.hasMoreTokens())
            arr[i++] = Integer.parseInt(input.nextToken());
        return arr;
    }

    public static void Permutation(List<List<Integer>> list,List<Integer> tempList,int[] arr,int index){
        if(index == arr.length)
        {
            list.add(new ArrayList<>(tempList));
            System.out.println(Arrays.toString(arr));
            return ;
        }
        for (int i = index; i < arr.length; i++) {
            // if(tempList.contains(arr[i])) continue;
            // tempList.add(arr[i]);
            swap(arr, i,index);
            Permutation(list, tempList, arr,index+1);
            // tempList.remove(tempList.size()-1);
            swap(arr,i, index);
        }
    }
    public static void swap(int[] arr,int start,int end){
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int[] arr = new int[input.countTokens()];
        arr = StringToInt(input);
        List<List<Integer>> list = new ArrayList<>();
        Permutation(list, new ArrayList<>(), arr,0);
        System.out.println();
        System.out.println();
        System.out.println();
        // for(List<Integer> lt : list){
        //     System.out.println(lt);
        // }
        
    }
    
}
