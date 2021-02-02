import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class DrugsFarm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        while(m != 0 && n != 0){
            int[][] graph = new int[n][m];
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph[0].length; j++) {
                    graph[i][j] = sc.nextInt();
                }
            }
            totalFarm(graph);
            n = sc.nextInt();
            m = sc.nextInt();
        }
        sc.close();
    }
    static ArrayList<Integer> output = new ArrayList<>();
    private static void totalFarm(int[][] graph) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int totalFarm = 0;
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                int count =0 ;
                if(graph[i][j] != 0){
                    count = dfs(graph,i,j);
                    totalFarm++;
                    if(map.containsKey(count))
                        map.put(count,map.get(count)+1);
                    else
                        map.put(count,1);
                }
                // System.out.println(count + "--for --" + i + "-" + j);
            }
        }
        System.out.println(totalFarm);
        for(Integer key : map.keySet()){
            System.out.println(key + " " + map.get(key));
        }
    }

    private static int dfs(int[][] graph, int i, int j) {
        if(i < 0 || j < 0 || i >= graph.length || j >= graph[0].length)
            return 0;
        if(graph[i][j] == 0)
            return 0;
        graph[i][j] = 0;
        int count = 0;
        count = 1 + dfs(graph, i+1, j);
        count = count + dfs(graph, i-1, j);
        count = count + dfs(graph, i, j+1);
        count = count + dfs(graph, i, j-1);
        return count;
    }
    
}
