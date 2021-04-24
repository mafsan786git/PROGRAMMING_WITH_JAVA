import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ConnectedComponent {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            
            LinkedList<Integer>[] graph = new LinkedList[n+1];
            for (int i = 1; i < graph.length; i++) {
                graph[i] = new LinkedList<>();
            }
            for(int i=0;i<m;i++){
                int u = sc.nextInt();
                int v = sc.nextInt();
                graph[u].add(v);
                graph[v].add(u);

            }
            int[] visited = new int[n+1];
            int count = 0;
            for (int i = 1; i < n+1; i++) {
                if(visited[i] == 0)
                {
                    Queue<Integer> q = new LinkedList<>();
                    q.add(i);
                    
                    while(q.isEmpty() == false){
                        int node = q.poll();
                        visited[node] = 1;
                        for (int child : graph[node]) {
                            if(visited[child] == 0){
                                q.add(child);
                            }
                        }
                        
                    }
                    count++;
                }
            }
            System.out.println(count);
        }

        sc.close();
    }
}