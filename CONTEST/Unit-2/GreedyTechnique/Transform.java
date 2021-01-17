import java.util.*;
import java.io.*;

public class Transform {
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
            Integer[] arr1 = new Integer[n];
            Integer[] arr2 = new Integer[n];
            input = new StringTokenizer(br.readLine());
            arr1 = StringToInt(input);
            input = new StringTokenizer(br.readLine());
            arr2 = StringToInt(input);

    
            HashSet<Integer> set = new HashSet<>();
            boolean flag = true;
            int valB=0;
            for (int i = 0; i < arr2.length; i++) {
                valB = arr2[i];
                if(i == 0)
                {
                    if(arr2[i] != arr1[i])
                    {
                        flag = false;
                        break;
                    }
                }else{
                    if(valB != arr1[i])
                    {
                        if(valB > 0)
                        {
                            if(!set.contains(1)){
                                flag = false;
                                break;
                            }
                            
                        }else if(valB < 0){
                            if(!set.contains(-1)){
                                flag = false;
                                break;
                            }
                        }else{
                            if(arr1[i] == 1 && !set.contains(-1)){
                                flag = false;
                                break;
                            }
                            if(arr1[i] == -1 && !set.contains(1)){
                                flag = false;
                                break;
                            }
                            if(!set.contains(0)){
                                flag = false;
                                break;
                            }
                        }
                    }
                }
                set.add(arr1[i]);
            }
            if(flag)
                System.out.println("YES");
            else
                System.out.println("NO");
        }

    }
    
}
