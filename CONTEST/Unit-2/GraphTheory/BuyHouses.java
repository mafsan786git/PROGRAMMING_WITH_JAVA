import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BuyHouses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            HashMap<Integer,ArrayList<Integer>> graph = new HashMap<>();
            HashSet<Integer> visited = new HashSet<>();
            for (int i = 0; i < n; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                if(graph.containsKey(u)){
                    graph.get(u).add(v);
                }if(graph.containsKey(v))
                    graph.get(v).add(u);
                else{
                    graph.put(u,new ArrayList<Integer>(Arrays.asList(v)));
                    graph.put(v,new ArrayList<Integer>(Arrays.asList(u)));
                }
            }
            int count = 0;
            for(Integer key : graph.keySet()){
                if(!visited.contains(key)){
                    visited.add(key);
                    count += bfs(key,graph, visited,0);
                }
            }
            System.out.println(count);
        }
        sc.close();
    }

    private static int bfs(int key,HashMap<Integer, ArrayList<Integer>> graph, HashSet<Integer> visited,int count) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(key);
        count++;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(Integer child : graph.get(cur)){
                if(!visited.contains(child)){
                    count++;
                    visited.add(child);
                    queue.add(child);
                }
            }
        }
        return count;
    }

}
