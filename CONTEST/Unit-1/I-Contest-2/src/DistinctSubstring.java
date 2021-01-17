import java.util.HashSet;
import java.util.Scanner;
public class DistinctSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(0 < t--){
            int n = sc.nextInt();
            sc.nextLine();
            String str = sc.nextLine();
            HashSet<String> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                String subStr = "";
                for (int j = i; j < n; j++) {
                    subStr += str.charAt(j);
                    set.add(subStr);
                }
            }
            System.out.println(set.size());
        }
    }
}
