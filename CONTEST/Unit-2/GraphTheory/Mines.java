import java.util.*;
public class Mines {
    private LinkedList<Integer> adj[];
    public Mines(int size){
        adj = new LinkedList[size+1];
        for (int i = 0; i <= size; i++) {
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
                count = Math.max(count,dfs(visited,i));
            }
        }
        
        return count;
    }
    
    private int dfs(boolean[] visited,int index) {
        visited[index] = true;
        int count =1;
        for(Integer val : adj[index]){
            if(!visited[val])
                count += dfs(visited, val);
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Mines graph = new Mines(n);
        int e = sc.nextInt();
        while(e-- > 0){
            int source = sc.nextInt();
            int desti = sc.nextInt();
            graph.addEdge(source,desti);
        }
        System.out.println(graph.CountConnected());

        sc.close();
    }
}
