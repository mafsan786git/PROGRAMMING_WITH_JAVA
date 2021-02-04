import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PriorityQueueUsingPair {
    static class Pair{
        Integer key,value;
        public Pair(int k, int v) {
            key = k;
            value = v;
        }
    }
    static class PairComparator implements Comparator<Pair>{
        @Override
        public int compare(Pair p1,Pair p2){
            if(p1.key > p2.key)
                return -1;
            return 1;
        }
    }
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(input.nextToken());
        int op = Integer.parseInt(input.nextToken());
        PriorityQueue<Pair> pq = new PriorityQueue<>(new PairComparator());
        while(t-- > 0){
            input = new StringTokenizer(br.readLine());
            Integer k = Integer.parseInt(input.nextToken());
            Integer v = Integer.parseInt(input.nextToken());
            pq.add(new Pair(k,v));
            
        }
        for(Pair p : pq){
            System.out.println(p.key + " -- " +p.value);
        }
        int score = 0;
        while(!pq.isEmpty() && op-- > 0){
            Pair p = pq.poll();
            score += p.key;
            if(p.key/p.value != 0)
                pq.add(new Pair(p.key/p.value,p.value));
            bw.write(p.key/p.value + " " +  p.value);
            bw.write("\n");
        }
        bw.write(score + "\n");
        bw.close();
        br.close();
    }
}