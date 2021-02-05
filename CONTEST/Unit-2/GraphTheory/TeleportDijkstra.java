
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class TeleportDijkstra {
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
        int vertices = sc.nextInt();
        int houseNumber = sc.nextInt();
        int time = sc.nextInt();
        int edge = sc.nextInt();
        @SuppressWarnings("unchecked")
        LinkedList<Edge>[] list = new LinkedList[vertices+1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new LinkedList<>();
        }
        for (int i = 0; i < edge; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int cost = sc.nextInt();
            list[src].add(new Edge(dest, cost));
        }
        int count = 0;
        for (int i = 1; i < list.length; i++) {
            count += shortestpathDijktra(list,i,time,houseNumber);
        }
        System.out.println(count);
        sc.close();
    }
    private static int shortestpathDijktra(LinkedList<Edge>[] list,int src,int time, int houseNumber) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(new Edge());
        int[] distance = new int[list.length];
        for (int i = 0; i < distance.length; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[src] = 0;
        boolean[] visited = new boolean[list.length];
        
        visited[houseNumber] = true;
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
        return (distance[houseNumber]<=time) ? 1 : 0;
    }
    
}
