import java.util.*;
import java.io.*;

public class InputTemplate {
    static int[] StringToInt(StringTokenizer input){
        int[] arr = new int[input.countTokens()];
        int i=0;
        while(input.hasMoreTokens())
            arr[i++] = Integer.parseInt(input.nextToken());
        return arr;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(10,9,8,7,6,5,3,4,2,1));
        Collections.sort(arr);
        StringTokenizer input = new StringTokenizer(br.readLine());
        
        int t = Integer.parseInt(input.nextToken());
        while(t-- > 0){
            input = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(input.nextToken());
            int[] boy = new int[n];

            input = new StringTokenizer(br.readLine());
            boy = StringToInt(input);
            input = new StringTokenizer(br.readLine());
            HashMap<Integer,Integer> map = new HashMap<>();
    
            map.size();
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
            // Arrays.sort(boy,new Comparator<Integer>(){
            //     public int compare(Integer a,Integer b){
            //        return Integer.valueOf(a).compareTo(Integer.valueOf(b));
            //     }
            // });

        }
        br.close();
        bw.close();

    }
    
}
