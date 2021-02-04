import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SSSpathOnGraph {
    public static void addEdge(LinkedList<Integer>[] adj,int source,int dest){
        adj[source].add(dest);
        adj[dest].add(source);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
      	int t = sc.nextInt();
      	while(t-- > 0)
        {
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

        /**Breadth first search is best for shortest single source path in Graph */
        bfsUtil(adj);
        boolean[] visited = new boolean[adj.length];
        int[] dis = new int[adj.length];
        dfsUtil(1, adj, visited, 0, dis);//not working
    }
    
    private static void bfsUtil(LinkedList<Integer>[] adj) {
        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[adj.length];
        int[] dis = new int[adj.length];
        queue.add(1);
        visited[1] = true;
        int count = 0;
        while(queue.isEmpty() == false){
            int cur = queue.poll();
            for (int temp : adj[cur]) {
                if(!visited[temp]){
                    queue.add(temp);
                    visited[temp] = true;
                    dis[temp] = dis[cur] + 1;
                    count++;
                }
            }
        }
        System.out.println(Arrays.toString(dis));
        System.out.println(dis[dis.length-1] + " -- " + count);
    }

    /**it will give stackoverflow in recursion */
    private static void dfsUtil(int node, LinkedList<Integer>[] adj, boolean[] visited, int count, int[] dis) {
        visited[node] = true;
        dis[node] = count;
        for (Integer child : adj[node]){
            if(!visited[child])
            {

                dfsUtil(child, adj, visited,count+1,dis);
            }
            dis[node] = Math.min(dis[node], dis[child]+1);
            dis[child] = Math.min(dis[node]+1, dis[child]);
                
        }
    }

    
}
