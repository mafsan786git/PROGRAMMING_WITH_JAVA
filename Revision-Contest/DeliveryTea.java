import java.io.*;
import java.util.*;

/**
 * Description
    There are N societies located in a city, which are connected with N-1 roads,.
    Each road takes a 1 minute of time to travel.
    Mahendra Modi, a tea shop owner, wants to start a new tea delivery shop in a city, such that maximum time it would take to delivery to a potential customer in any part of city is minimum. Because as time passes, tea becomes cold and customer would be unsatisfied.
    Help Modi to find minimum amount of time, choosing a society for his tea shop.
 */

public class DeliveryTea {
    private static int[] distance;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(input.nextToken());
        while(t-- > 0){
            input = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(input.nextToken());
            @SuppressWarnings("unchecked")
            List<Integer>[] graph = new ArrayList[n];
            for (int i = 0; i < graph.length; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int i = 0; i < graph.length-1; i++) {
                input = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(input.nextToken());
                int v = Integer.parseInt(input.nextToken());
                graph[u].add(v);
                graph[v].add(u);
            }
            distance = new int[n];
            visited = new boolean[n];
            distance[0] = 0;
            longestNode(graph, 0);
            int src = 0;
            int mx = distance[0];
            for (int i = 0; i < graph.length; i++) {
                if(mx < distance[i]){
                    mx = distance[i];
                    src = i;
                }
                distance[i] = 0;
                visited[i] = false;
            }
            longestNode(graph, src);
            mx = distance[0];
            for (int i = 0; i < graph.length; i++) {
                if(mx < distance[i]){
                    mx = distance[i];
                }
            }
            System.out.println((mx+1)/2);
            

        }
    }
    private static void longestNode(List<Integer>[] graph,int node){
        visited[node] = true;
        for(Integer child : graph[node]){
            if(!visited[child]){
                distance[child] = distance[node] + 1;
                longestNode(graph, child);
            }
        }

    }
}
