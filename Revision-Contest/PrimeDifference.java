import java.util.*;
/**
 * You are given two prime numbers of 4 digits each.
    You are allowed to perform following operations:-
    In one step, you can change one digit of a prime number, but new number formed should also be prime. And leading digit can not be changed to zero.
    You need to find minimum number of operations required to make a first prime number to second prime number.

 */
public class PrimeDifference {
    private static int[] distance;
    private static boolean[] visited;
    private static void buildGraph(ArrayList<Integer> prime,ArrayList<Integer>[] graph){
        for (int i = 0; i < prime.size(); i++) {
            int u = prime.get(i);
            for (int j = i+1; j < prime.size(); j++) {
                int v = prime.get(j);
                
                if(isValid(u,v)){
                    graph[u].add(v);
                    graph[v].add(u);
                }
            }
        }
    }

    private static boolean isValid(int a,int b){
        int count = 0;
        while(a > 0){
            if(a%10 != b%10) count++;
            a /= 10;
            b /= 10;
        }
        if(count == 1)
            return true;
        return false;
        
    }
    private static void generatePrime(ArrayList<Integer> prime){
        for (int i = 1000; i <= 9999; i++) {
            if(isPrime(i)) prime.add(i);
        }
    }
    private static boolean isPrime(int num){
        for (int i = 2; i*i <= num ; i++) {
            if(num % i == 0)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ArrayList<Integer> prime = new ArrayList<>(); 
        generatePrime(prime);

        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] graph = new ArrayList[10000];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        buildGraph(prime, graph);
        while(t-- > 0){
            int first = sc.nextInt();
            int second = sc.nextInt();
            distance = new int[10000];
            visited = new boolean[10000];
            System.out.println(minStepBfs(first,second,graph));
        }
        sc.close();
    }

    private static int minStepBfs(int src,int dest,ArrayList<Integer>[] graph){
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        visited[src] = true; 
        while(q.isEmpty()==false){
            int node = q.poll();
            // if(visited[node]) continue;
            // visited[node] = true;
            for(Integer child : graph[node]){
                if(!visited[child]){
                    q.add(child);
                    visited[child] = true;
                    distance[child] = distance[node] + 1;
                }
            }
        }

        return distance[dest];
    }
}