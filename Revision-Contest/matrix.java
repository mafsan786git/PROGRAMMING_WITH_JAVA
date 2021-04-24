
import java.util.*;

public class matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String vow = "aeiouAEIOU";
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < vow.length(); i++) {
            set.add(vow.charAt(i));
        }
        String str = sc.nextLine();
        char[] output = str.toCharArray();
        boolean flag = false;
        for (int i = 0; i < str.length(); i++) {
            if(set.contains(str.charAt(i))){
                int idx = i;
                int temp = idx*5;
                int num = 0;
                for (int j = 1; j <= temp; j++) {
                    if(j%2 != 0)
                        num += j;
                }
                while(num >=10){
                    temp = num;
                    num = 0;
                    while(temp > 0){
                        num += temp%10;
                        temp /= 10;
                    }
                }
                output[i] = (char)(num+'0');
                flag = true;
            }
        }
        if(flag)
            System.out.println(output);
        else
            System.out.println(-1);
        
        sc.close();
    }
}
