import java.util.ArrayList;
import java.util.Scanner;

public class NoMap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int q = sc.nextInt();
        while (q-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if(graph.get(x).contains(y))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        sc.close();
    }
    
}
