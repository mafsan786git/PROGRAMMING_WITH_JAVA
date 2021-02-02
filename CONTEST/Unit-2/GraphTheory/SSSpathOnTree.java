import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class SSSpathOnTree {
    
    public static void addEdge(LinkedList<Integer>[] adj,int source,int dest){
        adj[source].add(dest);
        adj[dest].add(source);
    }
    public static void main(String[] args) {
        // new Thread(null, new Main(), "Main", 1<<26).start();
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

            printMinDis(adj); 
        }

        sc.close();
    }

    private static void printMinDis(LinkedList<Integer>[] adj) {
        int[] dis = new int[adj.length];
        boolean[] visited = new boolean[adj.length];
        dfsUtil(1, adj, visited, 0, dis);
        // System.out.println(Arrays.toString(dis));
        System.out.println(dis[dis.length-1]);
    }
    private static void dfsUtil(int node,LinkedList<Integer>[] adj, boolean[] visited,int count,int[] dis) {
        visited[node] = true;
        dis[node] = count;
        for (Integer child : adj[node]){
            if(!visited[child])
            {
                dfsUtil(child, adj, visited,count+1,dis);
            }
        }
    }
    
}
