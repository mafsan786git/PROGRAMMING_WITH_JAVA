import java.util.Scanner;
public class LongestPrefix {

    int findMinLength(String []arr,int n){
        int minlength = arr[0].length();
        for (int i = 1; i < n; i++) {
            if(minlength > arr[i].length()) minlength = arr[i].length();
        }
        return minlength;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        LongestPrefix obj = new LongestPrefix();
        while(0 < t--){
            int n = sc.nextInt();
            sc.nextLine();
            String []arr = new String[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextLine();
            int minLen = obj.findMinLength(arr,n);
            String result = "";
            char temp;
            boolean flag = false;
            for (int i = 0; i < minLen; i++) {
                temp = arr[0].charAt(i);
                for (int j = 1; j < n; j++) {
                    if(temp != arr[j].charAt(i))
                    {
                        flag = true;
                        break;
                    }
                }
                if(flag) break;
                result += temp;
            }
            System.out.println(result);
        }
    }
}
