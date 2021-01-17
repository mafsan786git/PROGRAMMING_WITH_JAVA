import java.util.*;
import java.io.*;

public class InputTemplate {
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
        int t = Integer.parseInt(input.nextToken());
        while(t-- > 0){
            input = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(input.nextToken());
            int m = Integer.parseInt(input.nextToken());
            Integer[] boy = new Integer[n];
            Integer[] girl = new Integer[m];
            input = new StringTokenizer(br.readLine());
            boy = StringToInt(input);
            input = new StringTokenizer(br.readLine());
            girl = StringToInt(input);
        
            //ArrayList sorted using comparator
            ArrayList<ArrayList<Float>> values = new ArrayList<ArrayList<Float>>();
            for (int i = 0; i < boy.length; i++) {
                float temp =  boy[i]/(float)boy[i];
                values.add(new ArrayList<Float>(Arrays.asList(temp,(float)boy[i],(float)boy[i])));
            }
            Collections.sort(values, new Comparator<ArrayList<Float>>(){
                public int compare(ArrayList<Float> a,ArrayList<Float> b){
                    return a.get(0).compareTo(b.get(0));
                }
            });

        }

    }
    
}
