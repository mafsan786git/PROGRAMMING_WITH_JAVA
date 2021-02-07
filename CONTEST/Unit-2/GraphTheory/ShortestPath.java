// import java.io.*;
import java.util.*;
public class ShortestPath {
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
        int test = 1;
        while(test <= t){
            int vertices = sc.nextInt();
            @SuppressWarnings("unchecked")
            LinkedList<Edge>[] list = new LinkedList[vertices+1];
            for (int i = 0; i < list.length; i++) {
                list[i] = new LinkedList<>();
            }
            HashMap<String,Integer> map = new HashMap<>();
            for (int i = 1; i <= vertices; i++) {
                sc.nextLine();
                String str = sc.nextLine();
                map.put(str, i);
                int edge = sc.nextInt();
                for (int j = 0; j < edge; j++) {
                    int dest = sc.nextInt();
                    int cost = sc.nextInt();
                    list[i].add(new Edge(dest, cost));
                }
            }
            int query = sc.nextInt();
            sc.nextLine();
            while(query-- > 0){
                String[] str1 = sc.nextLine().split(" ");
                int src = map.get(str1[0]);
                int dst = map.get(str1[1]);
                int count = 0;
                // System.out.println(src + " - - " + dst);
                count = shortestpathDijktra(list, src,dst);
                System.out.println(count);
            }
            test++;
        }
        sc.close();
    }
    private static int shortestpathDijktra(LinkedList<Edge>[] list,int src,int dst) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(new Edge());
        int[] distance = new int[list.length];
        for (int i = 0; i < distance.length; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[src] = 0;
        boolean[] visited = new boolean[list.length];
        visited[dst] = true;
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
        return distance[dst];
    }
}
