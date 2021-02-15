import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;
public class FeasibleHackerEarth {
    private static boolean[] vis;
    private static int[] connected;
    private static int count;
    public FeasibleHackerEarth(int n){
        vis = new boolean[n+1];
        connected = new int[n+1];
        count = 0;
    }
    static class Edge{
        int first;
        int second;
        public Edge(int f,int s){
            first = f;
            second = s;
        }
    }
    private static void dfs(LinkedList<Integer>[] adjList,int src){
        vis[src] = true;
        connected[src] = count;
        for(Integer child : adjList[src]){
            if(!vis[child])
                dfs(adjList, child);
        }
    }
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(input.nextToken());
        while(t-- > 0){
            input = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(input.nextToken());
            int k = Integer.parseInt(input.nextToken());
            new FeasibleHackerEarth(n);
            @SuppressWarnings("unchecked")
            LinkedList<Integer>[] adjList = new LinkedList[n+1];
            for (int i = 0; i < adjList.length; i++) {
                adjList[i] = new LinkedList<>();
            }
            LinkedList<Edge> edgeList = new LinkedList<>();
            for (int i = 0; i < k; i++) {
                input = new StringTokenizer(br.readLine());
                int first = Integer.parseInt(input.nextToken());
                String op = input.nextToken().toString();
                int second = Integer.parseInt(input.nextToken());
                if(op.equals("="))
                {
                    adjList[first].add(second);
                    adjList[second].add(first);
                }else
                    edgeList.add(new Edge(first,second));
            }
            for (int i = 1; i < adjList.length; i++) {
                if(!vis[i]){
                    count++;
                    dfs(adjList,i);
                }
            }
            boolean flag = true;
            for (int i = 0; i < edgeList.size(); i++) {
                int first = edgeList.get(i).first;
                int second = edgeList.get(i).second;
                if(connected[first] == connected[second])
                {
                    flag = false;
                    break;
                }
            }
            if(flag)
                System.out.println("YES");
            else
                System.out.println("NO");
            
        }
    }
}
