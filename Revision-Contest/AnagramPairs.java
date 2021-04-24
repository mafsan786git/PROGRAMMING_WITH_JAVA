import java.util.*;
public class AnagramPairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            sc.nextLine();
            long count = 0;
            HashMap<String,Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String orgStr = sc.nextLine();
                char[] arr = orgStr.toCharArray();
                Arrays.sort(arr);
                String str = new String(arr);
                if(map.containsKey(str)){
                    count += map.get(str);
                    map.put(str,map.get(str)+1);
                }else
                    map.put(str,1);
            }
            System.out.println(count);
        }
        sc.close();
    }
}
