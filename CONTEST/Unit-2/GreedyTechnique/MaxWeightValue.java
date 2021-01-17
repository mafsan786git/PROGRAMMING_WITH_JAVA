
import java.io.*;
import java.util.*;

public class MaxWeightValue {
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
        int capacity = Integer.parseInt(input.nextToken());
        input = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(input.nextToken());
        input = new StringTokenizer(br.readLine());
        int[] value = new int[n];
        value = StringToInt(input);
        input = new StringTokenizer(br.readLine());
        int[] wt = new int[n];
        wt = StringToInt(input);
        ArrayList<ArrayList<Float>> values = new ArrayList<ArrayList<Float>>();
        for (int i = 0; i < wt.length; i++) {
            float temp =  wt[i]/(float)value[i];
            values.add(new ArrayList<Float>(Arrays.asList(temp,(float)wt[i],(float)value[i])));
        }
        Collections.sort(values, new Comparator<ArrayList<Float>>(){
            public int compare(ArrayList<Float> a,ArrayList<Float> b){
                return a.get(0).compareTo(b.get(0));
            }
        });
        double mx = 0d;
        for(ArrayList<Float> arr:values){
            int w =  Math.round(arr.get(1));
            int val =   Math.round(arr.get(2));
            if(capacity >= arr.get(1))
            {
                mx += val;
                capacity -= w;
            }else{
                double temp = (double)val/(double)w;
                mx += (capacity*temp);
                break;
            }
        }
        
        System.out.println(Math.round(mx));


    }
    
}
