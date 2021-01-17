import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class PalindromeString {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            int [] charArr = new int[256];
//            System.out.println(Arrays.toString(charArr));
            int l = sc.nextInt();
            sc.nextLine();
            String str = sc.nextLine();
            for (int i=0;i<l;i++)
                charArr[str.charAt(i)-'a']++;
            int odd=0,evn=0;
            for(int x : charArr)
                if(x%2 == 0 && x!=0)
                    evn++;
                else if(x%2!=0)
                    odd++;
            if(l%2 == 0)
                if(odd == 0)
                    System.out.println("YES");
                else
                    System.out.println("NO");
            else
                if(odd == 1)
                    System.out.println("YES");
                else
                    System.out.println("NO");
            t--;
        }
    }
}
