import java.util.*;
public class CycleDetDir {
    private static int[] visited;
    private static int White;
    private static int Grey;
    private static int Black;
    public CycleDetDir(int vertex){
        visited = new int[vertex];
        White = 0;
        Grey = 1;
        Black = -1;
    }
    public static void clearVisited(){
        for (int i = 0; i < visited.length; i++) {
            visited[i] = 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int vertex = sc.nextInt();
            int edge = sc.nextInt();
            new CycleDetDir(vertex);
            @SuppressWarnings("unchecked")
            LinkedList<Integer>[] graph = new LinkedList[vertex];
            for (int i = 0; i < graph.length; i++) {
                graph[i] = new LinkedList<>();
            }
            for (int i = 0; i < edge; i++) {
                int src = sc.nextInt();
                int dst = sc.nextInt();
                graph[src].add(dst);
            }
            boolean flag = false;
            for (int i = 0; i < graph.length; i++) {
                if(visited[i] == White){
                    // clearVisited();
                    flag = dfsDirectedCycle(graph,i);
                    if(flag)
                        break;
                }
            }
            if(flag)
                System.out.println("Cycle");
            else
                System.out.println("Not a cycle");

        }
        sc.close();
    }

    private static boolean dfsDirectedCycle(LinkedList<Integer>[] graph, int src) {
        visited[src] = Grey;
        for(Integer child : graph[src]){
            if(visited[child] == White){
                
                boolean flag = dfsDirectedCycle(graph, child);
                if(flag)
                    return true;
            }
            else if(visited[child] == Grey)
                return true;
        }
        visited[src] = Black;
        return false;
    }
    
}
