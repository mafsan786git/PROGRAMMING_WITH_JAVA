import java.util.*;

public class GroupAnagram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t =sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            sc.nextLine();
            HashMap<String,ArrayList<String>> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String orgStr = sc.nextLine();
                char[] arr = orgStr.toCharArray();
                Arrays.sort(arr);
                String str = new String(arr);
                // int num = Integer.parseInt(str);
               // HashSet<Integer> set = new HashSet<>();
            
                if(map.containsKey(str))
                    map.get(str).add(orgStr.toString());
                else{
                    map.put(str,new ArrayList<>());
                    map.get(str).add(orgStr.toString());
                }
            }
            for(String keyString : map.keySet()){
                ArrayList<String> strList = map.get(keyString);
                System.out.println(strList.size());
                for(String op : strList)
                    System.out.println(op);
            }
        }
        sc.close();
    }
}
