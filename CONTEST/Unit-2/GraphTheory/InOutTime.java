import java.util.*;
public class InOutTime {
    private static boolean[] visited;
    private static int[] inTime;
    private static int[] outTime;
    private static int time;
    public InOutTime(int vertex){
        visited = new boolean[vertex+1];
        inTime = new int[vertex+1];
        outTime = new int[vertex+1];
        time = 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertex = sc.nextInt();
        @SuppressWarnings("unchecked")
        LinkedList<Integer>[] graph = new LinkedList[vertex+1];
        for (int i = 1; i < graph.length; i++) {
            graph[i] = new LinkedList<>();
        }
        int edge = sc.nextInt();
        for (int i = 0; i < edge; i++) {
            int src = sc.nextInt();
            int dst = sc.nextInt();
            graph[src].add(dst);
            graph[dst].add(src);
        }
        int src = sc.nextInt();
        new InOutTime(vertex);
        dfsInOutTime(graph,src);
        for (int i = 1; i < inTime.length; i++) {
            System.out.println(i + " " + inTime[i] + " " + outTime[i]);
        }
        sc.close();
    }

    private static void dfsInOutTime(LinkedList<Integer>[] graph, int src) {
        inTime[src] = time++;
        visited[src] = true;
        for(Integer child : graph[src]){
            if(!visited[child])
                dfsInOutTime(graph, child);
        }
        outTime[src] = time++;
    }
    
}
