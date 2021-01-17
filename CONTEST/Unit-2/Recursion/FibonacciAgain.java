import java.util.Scanner;

public class FibonacciAgain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] visited = new long[n+1];
        visited[0] = 0;
        visited[1] = 1;
        System.out.println(NumberWays(n,visited));
        sc.close();
    }

    private static long NumberWays(int n,long[] visited) {
        if(n == 0)
            return 0;
        if(visited[n] > 0)
            return visited[n];

        visited[n] = NumberWays(n - 1, visited) + NumberWays(n - 2, visited);
        return visited[n];
    }
}
