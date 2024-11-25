
    import java.io.*;
    import java.lang.*;
    import java.util.*;
    
    class BfsCycle {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine().trim());
            while (T-- > 0) {
                String[] s = br.readLine().trim().split(" ");
                int V = Integer.parseInt(s[0]);
                int E = Integer.parseInt(s[1]);
                ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
                for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
                for (int i = 0; i < E; i++) {
                    String[] S = br.readLine().trim().split(" ");
                    int u = Integer.parseInt(S[0]);
                    int v = Integer.parseInt(S[1]);
                    adj.get(u).add(v);
                    adj.get(v).add(u);
                }
                Solution obj = new Solution();
                boolean ans = obj.isCycle(adj);
                if (ans)
                    System.out.println("1");
                else
                    System.out.println("0");
    
                System.out.println("~");
            }
        }
    }    
    
    class Solution {
        // Function to detect cycle in an undirected graph.
        public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
            // Code here
            // return usingBFS(adj);
            return usingDfs(adj);
        }

        private boolean usingDfs(ArrayList<ArrayList<Integer>> adj){
            int size = adj.size();
            boolean[] visited = new boolean[size];
            for(int i=0; i < size ; i++){
                if(!visited[i]){
                    if(dfs(adj,i,visited,-1)) return true;
                }
            }
            return false;
        }
        
        private boolean dfs(ArrayList<ArrayList<Integer>> adj,int node,boolean[] visited,int parent){
            visited[node] = true;
            
            for(int neighbor : adj.get(node)){
                if(!visited[neighbor]){
                    if(dfs(adj,neighbor,visited,node)) return true;
                }else if(neighbor != parent) return true;
            }
            return false;
        }
        
        private boolean usingBFS(ArrayList<ArrayList<Integer>> adj){
            int size = adj.size();
            boolean[] visited = new boolean[size];
            for(int i=0; i < size ; i++){
                visited[i] = false;
            }
            for(int i=0; i < size ; i++){
                if(!visited[i]){
                    if(bfs(adj,i,visited)) return true;
                }
            }
            return false;
        }
        
        private boolean bfs(ArrayList<ArrayList<Integer>> adj,int node,boolean[] visited){
            visited[node]  = true;
            Queue<AbstractMap.SimpleEntry<Integer,Integer>> queue = new ArrayDeque<>();
            queue.add(new AbstractMap.SimpleEntry<>(node,-1));
            while(!queue.isEmpty()){
                AbstractMap.SimpleEntry<Integer,Integer> nodePair = queue.poll();
                Integer currentNode = nodePair.getKey();
                Integer currentParent = nodePair.getValue();
                for(Integer neighbor : adj.get(currentNode)){
                    if(!visited[neighbor]){
                        visited[neighbor]  = true;
                        queue.add(new AbstractMap.SimpleEntry<>(neighbor,currentNode));
                    }
                    else if(!currentParent.equals(neighbor)) return true;
                }
            }
            return false;
        }
    }