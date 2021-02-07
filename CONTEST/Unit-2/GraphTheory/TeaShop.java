import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class TeaShop {
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
            int edge = vertex-1;
            @SuppressWarnings("unchecked")
            LinkedList<Integer> adj[] = new LinkedList[vertex];
            for (int i = 0; i <adj.length; i++) {
                adj[i] = new LinkedList<>();
            }
            for (int i = 0; i < edge;i++) {
                int source = sc.nextInt();
                int dest = sc.nextInt();
                addEdge(adj, source, dest);
            }
            int[] dis = new int[adj.length];
            int src = bfsUtil(adj, dis, 0);
            src = bfsUtil(adj, dis, src);
            System.out.println((dis[src]+1)/2);

        }
        sc.close();
    }
    private static int bfsUtil(LinkedList<Integer>[] adj,int[] dis,int src) {
        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[adj.length];
        for (int i = 0; i < dis.length; i++) {
            dis[i] = 0;
        }
        queue.add(src);
        while(queue.isEmpty() == false){
            int cur = queue.poll();
            if(visited[cur]) continue;
            visited[cur] = true;
            for (int temp : adj[cur]) {
                if(!visited[temp]){
                    queue.add(temp);
                    dis[temp] = dis[cur] + 1;
                }
            }
        }
        int index = 0;
        int mx = dis[0];
        for (int i = 0; i < dis.length; i++) {
            if(dis[i] > mx){
                index = i;
                mx = dis[i];
            }
        }
        return index;
    }
}
