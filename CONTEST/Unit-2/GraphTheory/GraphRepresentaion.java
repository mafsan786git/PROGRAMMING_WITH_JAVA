import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GraphRepresentaion {
    public static void addEdge(LinkedList<Integer>[] adj,int source,int dest){
        adj[source].add(dest);
        adj[dest].add(source);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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

        printNode(adj);

        sc.close();
    }

    private static void printNode(LinkedList<Integer>[] adj) {
        System.out.println("Printing node in breath first search....");
        bfsUtil(adj);

        System.out.println("Printing node in depth first search....");
        boolean[] visited = new boolean[adj.length];
        visited[0] = true;
        int countComponenet = 0;
        for (int i = 0; i < adj.length; i++) {
            if(!visited[i]){
                countComponenet++; // for connected componenet
                dfsUtil(i,adj,visited);
            }
        }
        System.out.println(countComponenet);
        
    }

    private static void dfsUtil(int node,LinkedList<Integer>[] adj, boolean[] visited) {
        visited[node] = true;
        for (Integer child : adj[node]){
            if(!visited[child])
            {
                System.out.println(node + " --- " + child);
                dfsUtil(child, adj, visited);
            }
        }
    }

    private static void bfsUtil(LinkedList<Integer>[] adj) {
        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[adj.length];
        queue.add(1);
        visited[1] = true;
        while(queue.isEmpty() == false){
            int cur = queue.poll();
            for (int temp : adj[cur]) {
                if(!visited[temp]){
                    queue.add(temp);
                    System.out.println(temp);
                    visited[temp] = true;
                }
            }
        }
    }
}
