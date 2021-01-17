import java.io.*;
import java.util.*;

public class DoctorSubsetAgain{
    static int[] StringToInt(StringTokenizer input){
        int[] arr = new int[input.countTokens()];
        int i=0;
        while(input.hasMoreTokens())
            arr[i++] = Integer.parseInt(input.nextToken());
        return arr;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(input.nextToken());
        input = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        arr = StringToInt(input);
        Arrays.sort(arr);
        allSubset(arr,0,new ArrayList<>());
    }

    private static void allSubset(int[] arr, int index, ArrayList<Integer> ans) {
        System.out.println(ans);
        for (int i = index; i < arr.length; i++) {
            if(i > index && arr[i] == arr[i-1]) continue;
            ans.add(arr[i]);
            allSubset(arr, i+1, ans);
            ans.remove(ans.size()-1);
            
        }
    }
    
}