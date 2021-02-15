import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class CycleDetUndiDfs {
    private static boolean[] visited;
    public CycleDetUndiDfs(int vertex){
        visited = new boolean[vertex+1];
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
        new CycleDetUndiDfs(vertex);
        // System.out.print(Arrays.toString(visited));
        System.out.println((dfsCycleDetect(graph,-1,1)) ? "cycle is present" : "No cycle");
        // System.out.print(Arrays.toString(visited));
        sc.close();
    }
    private static boolean dfsCycleDetect(LinkedList<Integer>[] graph, int parent,int src) {
        visited[src] = true;
        // System.out.println(parent + " -||- " + src);
        for(Integer child:graph[src]){
            if(!visited[child]){
                if(dfsCycleDetect(graph, src,child))
                    return true;
                    // System.out.println(parent + " -after dfs- "+ child);
            }else if(parent != child){
                // System.out.println(parent + " -- "+ child);
                return true;
            }
        }
        return false;
    } 
}
