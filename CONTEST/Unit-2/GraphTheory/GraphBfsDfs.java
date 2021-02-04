import java.util.*;
// import java.io.*;

public class GraphBfsDfs {
    
    private LinkedList<Integer> adj[];
    public GraphBfsDfs(int size){
        adj = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int source,int desti){
        adj[source].add(desti);
        adj[desti].add(source);
    }
    public int CountConnected(){
        int count=0;
        boolean[] visited = new boolean[adj.length];
        for (int i = 0; i < adj.length; i++) {
            if(!visited[i])
            {
                count++;
                dfs(visited,i);
            }
        }
        
        return count;
    }
    
    private void dfs(boolean[] visited,int index) {
        visited[index] = true;
        for(Integer val : adj[index]){
            if(!visited[val])
                dfs(visited, val);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            GraphBfsDfs graph = new GraphBfsDfs(n);
            int e = sc.nextInt();
            while(e-- > 0){
                int source = sc.nextInt();
                int desti = sc.nextInt();
                graph.addEdge(source,desti);
            }
            System.out.println(graph.CountConnected());

        }
        sc.close();
    }
    
    
}
