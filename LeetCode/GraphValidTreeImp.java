import java.util.*;


class Solution {
    private List<List<Integer>> adjList = new ArrayList<>();
    private Set<Integer> seen = new HashSet<>();
    public boolean validTree(int n, int[][] edges) {
        for(int i = 0;i < n;i++){
           adjList.add(new ArrayList<>()); 
        }
        
        for(int[] edge : edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        
        // return usingDfsIterative(n);
        
        // return usingDfs(0,-1) && seen.size() == n;
        
        // return advanceGraphUsingDfs(n,edges);
        
        // advanceGraphUsingDfs(0);
        // return seen.size() == n;
        
        return usingUnionFind(n,edges);
        
    }
    
    private boolean usingDfs(int node, int parent){
        if(seen.contains(node)) return false;
        seen.add(node);
        for(Integer neighbour : adjList.get(node)){
            if(parent != neighbour){
                boolean result = usingDfs(neighbour, node);
                if(!result) return false;
            }
        }
        return true;
    }
    
    private boolean usingDfsIterative(int n){
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        Map<Integer,Integer> parent = new HashMap<>();
        parent.put(0,-1);
        while(!stack.isEmpty()){
            Integer node = stack.pop();
            for(Integer neighbour : adjList.get(node)){
                if(parent.get(node) == neighbour) continue;
                
                if(parent.containsKey(neighbour)) return false;
                
                stack.push(neighbour);
                parent.put(neighbour,node);
            }
        }
        return parent.size() == n;
        
    }
    
    private boolean advanceGraphUsingDfsIterative(int n,int[][] edges){
        if(edges.length != n-1) return false;
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        seen.add(0);
        while(!stack.isEmpty()){
            Integer node = stack.pop();
            for(Integer neighbour : adjList.get(node)){
                if(seen.contains(neighbour)) continue;
                stack.push(neighbour);
                seen.add(neighbour);
            }
        }
        return seen.size() == n;
    }
    
    private void advanceGraphUsingDfs(int node){
        if(seen.contains(node)) return;
        seen.add(node);
        for(Integer neighbour : adjList.get(node)){
            advanceGraphUsingDfs(neighbour);
        }
    }
    
    private boolean usingUnionFind(int n,int[][] edges){
        if(edges.length != n-1) return false;
        UnionFind uf = new UnionFind(n);
        
        for(int[] edge : edges){
            if(!uf.union(edge[0],edge[1])){
                return false;
            }
        }
        
        return true;
    }
}

class UnionFind{
    private int[] root;
    private int[] rank;
    
    public UnionFind(int size){
        root = new int[size];
        rank = new int[size];
        for(int i = 0;i< size; i++){
            root[i] = i;
            rank[i] = 1;
        }
    }
    
    public int find(int x){
        if(root[x] != x){
            root[x] = find(root[x]);
        }
        return root[x];
    }
    
    public boolean union(int x,int y){
        int rootX = find(x);
        int rootY = find(y);
        
        if(rootY == rootX) return false;
        
        if(rank[rootX] > rank[rootY]){
            root[rootY] = rootX;
        }else if(rank[rootX] < rank[rootY]){
            root[rootX] = rootY;
        }else{
            root[rootX] = rootY;
            rank[rootY]++;
        }
        return true;
    }
}

public class GraphValidTreeImp {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.validTree(5, null);
    }
}