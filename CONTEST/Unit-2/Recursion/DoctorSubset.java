
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DoctorSubset{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        allSubset(n,1,new ArrayList<>());
    }
    private static void allSubset(int n, int index, List<Integer> ans) {
        
        for(Integer val : ans)
            System.out.print(val + " ");
        System.out.println();
        for (int i = index; i <= n; i++) {
            ans.add(i);
            allSubset(n, i+1, ans);
            ans.remove(ans.size()-1);
        }
    }
}