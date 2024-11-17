
import java.util.*;


class ConnectedSolution {
    private List<List<Integer>> adjList = new ArrayList<>();
    private Set<Integer> seen = new HashSet<>();
    public int countComponents(int n, int[][] edges) {
        for(int i = 0 ;i < n ;i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        // return usingDfsIterative(n);
        
        return usingUnionFind(n,edges);
    }
    
    private int usingUnionFind(int n, int[][] edges){
        ConnectedUnionFind uf = new ConnectedUnionFind(n);
        int connected = 0;
        
        for(int i=0; i<edges.length; i++){
            connected += uf.union(edges[i][0],edges[i][1]);
        }
        return connected;
    }
    
    private int usingDfsIterative(int n){
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i < n ; i++){
            if(seen.contains(i)) continue;
            stack.add(i);
            seen.add(i);
            count++;
            while(!stack.isEmpty()){
                Integer node = stack.pop();
                for(Integer neighbour : adjList.get(node)){
                    if(seen.contains(neighbour)) continue;
                    
                    stack.add(neighbour);
                    seen.add(neighbour);
                }
            }
        }
        return count;
    }
}

class ConnectedUnionFind{
    private int[] root;
    private int[] rank;
    
    public ConnectedUnionFind(int size){
        root = new int[size];
        rank = new int[size];
        for(int i=0; i<size; i++){
            root[i] = i;
            rank[i] = 1;
        }
    }
    
    public int find(int x){
        if(root[x] != x)
            root[x] = find(root[x]);
        return root[x];
    }
    
    public int union(int x,int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX == rootY) return 0;
        
        if(rank[rootX] > rank[rootY]){
            root[rootY] = rootX;
            return 0;
        }
        if(rank[rootX] < rank[rootY]){
            root[rootX] = rootY;
            return 0;
        }
        root[rootX] = rootY;
        rank[rootY]++;
        return 1;
    }

}

public class NumberOfConnected {
    public static void main(String[] args){

    }
}