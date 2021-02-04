import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;


public class DataInterpetation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while((str=br.readLine()).charAt(0) != '0' && str.length() > 1)
        {
            HashSet<String> data = new HashSet<>();
            for (int i = 1; i < 27; i++) {
                data.add(i + "");
            }
            // waysOfdata(str, 0, data);
            System.out.println(waysOfdata(str, 0, data));
        }
        
    }

    private static int waysOfdata(String str,int index,HashSet<String> data){
        if(index == str.length())
            return 1;

        int count = 0;
        if(data.contains(str.subSequence(index,index+1)))
        {
            if(!(index+1 != str.length() && str.charAt(index+1) == '0'))   
                count += waysOfdata(str, index+1, data);
        }
           
        if(index+1 < str.length() && data.contains(str.subSequence(index,index+2))){
            count += waysOfdata(str, index+2, data);
        }
        return count;
        
    }
    
}
