import java.io.*;
import java.util.*;
public class EmergencyPathFromSource {
    static HashSet<Integer> set = new HashSet<>();
    static int[] StringToInt(StringTokenizer input){
        int[] arr = new int[input.countTokens()];
        int i=0;
        while(input.hasMoreTokens())
            arr[i++] = Integer.parseInt(input.nextToken());
        return arr;
    }

    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        // BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int vertices = Integer.parseInt(input.nextToken());
        int edge = Integer.parseInt(input.nextToken());
        int numHospital = Integer.parseInt(input.nextToken());
        int distanceFromhospital = Integer.parseInt(input.nextToken());
        @SuppressWarnings("unchecked")
        LinkedList<Integer>[] adjList = new LinkedList[vertices+1];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new LinkedList<>();
        }
        for (int i = 0; i < edge; i++) {
            input = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(input.nextToken());
            int dest = Integer.parseInt(input.nextToken());
            addEdge(adjList,src,dest);
        }
        int[] hospital = new int[numHospital];
        input = new StringTokenizer(br.readLine());
        hospital = StringToInt(input);
        // System.out.println(Arrays.toString(hospital));
        /**optimised*/
        breadthFirstSearchOptimised(adjList,hospital,distanceFromhospital);

        /**Not much optimised */
        for (int i = 0; i < hospital.length; i++) {
            breadthFirstSearch(adjList,hospital[i],distanceFromhospital);
        }
        bw.write((set.size() + numHospital)+"\n");
        br.close();
        bw.close();
    }
    
    private static void breadthFirstSearchOptimised(LinkedList<Integer>[] adjList, int[] hospital,int distFrHos) {
        Queue<Integer> queue = new LinkedList<>();
        int[] distance = new int[adjList.length];
        for (int i = 0; i < distance.length; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < hospital.length; i++) {
            queue.add(hospital[i]);
            distance[hospital[i]] = 0;
        }
        // System.out.println("queee --- " + queue);
        boolean[] visited = new boolean[adjList.length];
        while(!queue.isEmpty()){
            int src = queue.poll();
            visited[src] = true;
            for (Integer child : adjList[src]) {
                if(!visited[child])
                {
                    distance[child] = Math.min(1 + distance[src],distance[child]);
                    // System.out.println(Arrays.toString(distance));
                    // visited[child] = true;
                    queue.add(child);
                }
            }
        }
        int count=0;
        for (int i = 1; i < distance.length; i++) {
            if(distance[i]<= distFrHos)
                count++;
        }
        // System.out.println(Arrays.toString(distance));
        System.out.println(count);
        
    }

    private static void breadthFirstSearch(LinkedList<Integer>[] adjList, int src, int dFH) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[adjList.length];
        int[] distance = new int[adjList.length];
        queue.add(src);
        visited[src] = true;
        distance[src] = 0;
        while(!queue.isEmpty()){
            int parent  = queue.poll();
            if(distance[parent] >= dFH)
                continue;
            for(Integer child : adjList[parent])
            {
                if(!visited[child]){
                    queue.add(child);
                    visited[child] = true;
                    distance[child] = 1 + distance[parent];
                    set.add(child);
                }
            }
        }    
    }
    private static void addEdge(LinkedList<Integer>[] adjList, int src, int dest) {
        adjList[src].add(dest);
        adjList[dest].add(src);
    }

}
