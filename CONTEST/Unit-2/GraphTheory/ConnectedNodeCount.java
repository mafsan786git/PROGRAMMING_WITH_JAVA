
import java.util.*;
public class ConnectedNodeCount {
    static int count =0;
    public static void CountConnected(LinkedList<Integer>[] adj) {
        int mn = Integer.MAX_VALUE;
        boolean[] visited = new boolean[adj.length];
        for (int i = 1; i < adj.length; i++) {
            if(!visited[i])
            {
                count=0;
                System.out.println("bfs count- -"+dfs(adj,visited,i,1));
                System.out.println(count);
                mn = Math.min(mn, count);
            }
        }
        System.out.println(mn);
    }
    private static int dfs(LinkedList<Integer>[] adj, boolean[] visited, int index,int cnt) {
        visited[index] = true;
        count++;
        for(Integer val : adj[index]){
            if(!visited[val]){
             return dfs(adj,visited, val,cnt+1);
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        @SuppressWarnings("unchecked")
        LinkedList<Integer>[] adj = new LinkedList[n+1];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new LinkedList<>();
        }
        int e = sc.nextInt();
        while(e-- > 0){
            int source = sc.nextInt();
            int desti = sc.nextInt();
            adj[source].add(desti);
            adj[desti].add(source); 
        }
        CountConnected(adj);
        sc.close();
    }
    
    
}
