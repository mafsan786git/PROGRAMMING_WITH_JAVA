import java.io.*;
import java.util.*;
public class BipartiteGraph {

    public static void addEdge(LinkedList<Integer>[] adj,int source,int dest){
        adj[source].add(dest);
        adj[dest].add(source);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int vertex = sc.nextInt();
            int edge = sc.nextInt();
            @SuppressWarnings("unchecked")
            LinkedList<Integer> adj[] = new LinkedList[vertex+1];
            for (int i = 0; i <adj.length; i++) {
                adj[i] = new LinkedList<>();
            }
            for (int i = 0; i < edge;i++) {
                int source = sc.nextInt();
                int dest = sc.nextInt();
                addEdge(adj, source, dest);
            }
            if(printNode(adj))
                System.out.println("Bipartite graph");
            else
                System.out.println("Non-Bipartite graph");
        }
        sc.close();
    }

    private static boolean printNode(LinkedList<Integer>[] adj) {
        boolean[] visited = new boolean[adj.length];
        int[] color = new int[adj.length];
        for (int i = 1; i < color.length; i++) {
            if(!visited[i]){
                if(!dfs(i,adj,visited,color,1))
                    return false;
            }
        }
        return true;
    }

    private static boolean dfs(int node, LinkedList<Integer>[] adj, boolean[] visited, int[] color,int c) {
        visited[node] = true;
        color[node] = c;
        // System.out.println(c);
        for(Integer child  : adj[node])
        {
            if(!visited[child]){
                if(!dfs(child, adj, visited, color,c^3))
                    return false;
            }else if(color[child] == color[node])
                return false;
        }
        return true;
    }
    
}
