import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PrimeDifference {
    private static int[] distance = new int[10000];
    private static boolean[] vis = new boolean[10000];

    private static void buildGraph(LinkedList<Integer>[] adjList) {
        LinkedList<Integer> prime = new LinkedList<>();
        for (int i = 1000; i <=9999; i++) {
            if(isPrime(i))
                prime.add(i);
        }
        for (int i = 0; i <prime.size() ;i++) {
                for (int j = i+1; j < prime.size(); j++) {
                    int a = prime.get(i);
                    int b = prime.get(j);
                    if(isValid(a,b))
                    {
                        adjList[a].add(b);
                        adjList[b].add(a);
                    }
                }
        }
    }
    
    private static boolean isValid(int a, int b) {
        int count = 0;
        while(a > 0){
            if(a%10 != b%10) count++;
            a /= 10;b /= 10;
        }
        if(count == 1) return true;
        return false;
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i*i <= num; i++) {
            if(num%i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        @SuppressWarnings("unchecked")
        LinkedList<Integer>[] adjList = new LinkedList[10000];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new LinkedList<>();
        }
        buildGraph(adjList);
        while(t-- > 0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            for (int i = 1000; i <=9999; i++) {
                distance[i] = 0;
                vis[i] = false;
            }
            bfs(adjList,a);
            System.out.println(distance[b]);

        }
    }

    private static void bfs(LinkedList<Integer>[] adjList, int src) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        while(!queue.isEmpty()){
            src = queue.poll();
            for(Integer child : adjList[src]){
                if(!vis[child]){
                    queue.add(child);
                    distance[child] = 1 + distance[src];
                    vis[child] = true;
                }
            }
        }
    }
}
