
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

import java.util.Scanner;
public class NamasteBiden {
    static class Edge implements Comparator<Edge>{
        int dest;
        int cost;
        public Edge(int dest,int cost){
            this.dest = dest;
            this.cost = cost;
        }
        public Edge(){}
        public int compare(Edge e1,Edge e2){
            return e1.cost-e2.cost;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
      	int t = sc.nextInt();
      	while(t-- > 0)
        {
         	int vertex = sc.nextInt();
            int edge = vertex-1;
            @SuppressWarnings("unchecked")
            LinkedList<Edge> adj[] = new LinkedList[vertex+1];
            for (int i = 0; i <adj.length; i++) {
                adj[i] = new LinkedList<>();
            }
            for (int i = 0; i < edge;i++) {
                int source = sc.nextInt();
                int dest = sc.nextInt();
                int cost = sc.nextInt();
                adj[source].add(new Edge(dest, cost));
                adj[dest].add(new Edge(source, cost));
            }
            int[] distance = new int[adj.length];
            int src = shortestpathDijktra(adj,1, distance);
            src = shortestpathDijktra(adj, src, distance);
            System.out.println(distance[src]); 
        }
        sc.close();
    }
    
    private static int shortestpathDijktra(LinkedList<Edge>[] list,int src,int[] distance) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(new Edge());
        
        for (int i = 0; i < distance.length; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[src] = 0;
        boolean[] visited = new boolean[list.length];
        pq.add(new Edge(src,0));
        while(!pq.isEmpty()){
            Edge e = pq.poll();
            int source = e.dest;
            int cost = e.cost;
            if(visited[source]) continue;
            visited[source] = true;
            for(Edge child : list[source]){
                if(cost + child.cost < distance[child.dest]){
                    distance[child.dest] = cost + child.cost;
                    pq.add(new Edge(child.dest,distance[child.dest]));
                }
            }
        }
        
        // System.out.println(Arrays.toString(distance));
        int index = 1;
        int mx = distance[1];
        for (int i = 1; i < distance.length; i++) {
            if(distance[i] > mx){
                index = i;
                mx = distance[i];
            }
        }
        return index;
    }
}
