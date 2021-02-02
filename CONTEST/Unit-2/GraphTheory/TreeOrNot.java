
import java.util.*;
public class TreeOrNot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertex = sc.nextInt();
        int edge = sc.nextInt();
        @SuppressWarnings("unchecked")
        LinkedList<Integer> adj[] = new LinkedList[vertex+1];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new LinkedList<>();
        }
        for (int i = 0; i < edge;i++) {
            int source = sc.nextInt();
            int dest = sc.nextInt();
            adj[source].add(dest);
            adj[dest].add(source);
        }

        int count=0;
        boolean[] visisted = new boolean[vertex+1];
        for (int i = 1; i < adj.length; i++) {
            if(!visisted[i]){
                count++;
                dfs(i,adj,visisted);
            }
        }
        if(count == 1 && edge == vertex-1)
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    private static void dfs(int node,LinkedList<Integer>[] adj, boolean[] visisted) {
        visisted[node] = true;
        for(Integer child:adj[node]){
            if(!visisted[child])
                dfs(child, adj, visisted);
        }
    }
    
}
