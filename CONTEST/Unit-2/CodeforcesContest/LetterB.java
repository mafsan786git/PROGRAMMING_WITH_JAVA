import java.io.*;

public class LetterB {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] heading = br.readLine().split(" ");
        String[] text = br.readLine().split(" ");
        boolean flag = true;
        for (int i = 0; i < text.length; i++) {
                if(!isStringPresent(text[i], heading)){
                    flag = false;
                    break;
                }
        }
        if(flag)
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    private static boolean isStringPresent(String str,String[] heading){
        for (int k = 0; k < str.length(); k++) {
            boolean flag = false;
            for (int i = 0; i < heading.length; i++) {
                StringBuilder temp = new StringBuilder(heading[i]);
                for (int j = 0; j < temp.length(); j++) {
                    if(temp.charAt(j) == str.charAt(k))
                    {
                        temp.setCharAt(j, '*');
                        heading[i] = temp.toString();
                        flag = true;
                        break;
                    }
                }
                if(flag)
                    break;
            }
            if(!flag)
                return false;
        }
        
        return true;
    }
    
}
