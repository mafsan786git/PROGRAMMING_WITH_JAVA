import java.util.*;
import java.io.*;

public class Pokeman {
    static Integer[] StringToInt(StringTokenizer input){
        Integer[] arr = new Integer[input.countTokens()];
        int i=0;
        while(input.hasMoreTokens())
            arr[i++] = Integer.parseInt(input.nextToken());
        return arr;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(input.nextToken());
        while(t-- > 0){
            input = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(input.nextToken());
            Integer[] ash = new Integer[n];
            Integer[] gary = new Integer[n];
            input = new StringTokenizer(br.readLine());
            ash = StringToInt(input);
            input = new StringTokenizer(br.readLine());
            gary = StringToInt(input);
    
            Arrays.sort(ash,new Comparator<Integer>(){
                public int compare(Integer a,Integer b){
                    return b-a;
                }
            });
            Arrays.sort(gary,new Comparator<Integer>(){
                public int compare(Integer a,Integer b){
                    return b-a;
                }
            });
            System.out.println(Arrays.toString(ash));
            System.out.println(Arrays.toString(gary));
            boolean flag = true;
            for (int i = 0; i < gary.length; i++) {
                if(ash[i] <= gary[i])
                {
                    flag = false;
                    break;
                }
            }
            if(flag)
                System.out.println("Ash Finally Wins");
            else
                System.out.println("Train Hard Again"); 
        
        }

    }
    
}
