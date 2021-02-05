import java.io.*;
import java.util.Comparator;
// import java.util.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class DijkstrasAlgorithm {
    private int vertices;
    private LinkedList<Edges>[] adjList;
    private int[] distance;
    private PriorityQueue<Edges> pq;
    public DijkstrasAlgorithm(int vert){
        vertices = vert+1;
        adjList = new LinkedList[vertices];
        distance = new int[vertices];
        pq = new PriorityQueue<Edges>(vertices,new Edges());
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new LinkedList<>();
        }
    }
    

    static class Edges implements Comparator<Edges>{
        int dest;
        int weight;
        public Edges(){}
        public Edges(int dest,int weight){
            this.dest = dest;
            this.weight = weight;
        }
        public int compare(Edges edg1,Edges edg2){
            return edg1.weight-edg2.weight;
        }
    }
    public void addEdge(int source,int dest,int weight){
        adjList[source].add(new Edges(dest, weight));
    }
    public void shortestpathDijktra(){
        for (int i = 0; i < distance.length; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[1] = 0;
        boolean[] visited  = new boolean[vertices];
        // System.out.println(pq);
        pq.add(new Edges(1,0));
        while (!pq.isEmpty()) {
            Edges edg = pq.poll();
            int source =edg.dest;
            int cost = edg.weight;
            visited[source] = true;
            LinkedList<Edges> list = adjList[source];
            for (int i = 0; i < list.size(); i++) {
                int dest = list.get(i).dest;
                if(!visited[dest]){
                    distance[dest] = Math.min(distance[dest], cost+list.get(i).weight);
                    pq.add(new Edges(dest,distance[dest]));
                }
            }
        }
    }
    public void printDis(){
        for (int i = 1; i < distance.length; i++) {
            System.out.println(i + " ---- "+ distance[i]);
        }
        System.out.println("Printing graph ---- ");
        for (int i = 1; i < adjList.length; i++) {
            for(Edges edge : adjList[i])
                System.out.println(i+ " -> " + edge.dest + " -- " + edge.weight);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int vertex = Integer.parseInt(input.nextToken());
        int edge = Integer.parseInt(input.nextToken());
        DijkstrasAlgorithm graph =  new DijkstrasAlgorithm(vertex);
        for (int i = 0; i < edge; i++) {
            input = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(input.nextToken());
            int dest = Integer.parseInt(input.nextToken());
            int weight = Integer.parseInt(input.nextToken());
            graph.addEdge(src, dest, weight);
        }
        graph.shortestpathDijktra();
        graph.printDis();
        br.close();
        bw.close();
    }
    
}
