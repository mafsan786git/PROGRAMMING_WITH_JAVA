import java.util.Scanner;

public class MonkeyTreeDfs {
    private static int count = 0;
    private static int height;
    private static int banana;
    private static int start;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        height = sc.nextInt();
        start = sc.nextInt();
        banana = sc.nextInt();
        int upWard = sc.nextInt();
        int downWard = sc.nextInt();
        dfsUpWard(upWard);
        if(start != banana)
            dfsDownWard(downWard);
        if(start == banana)
            System.out.println(count);
        else
            System.out.println(-1);

        

    }
    private static void dfsUpWard(int steps){
        if(start<banana){
            count++;
            start += steps;
            dfsUpWard(steps);
        }
    }
    private static void dfsDownWard(int steps){
        if(start > banana){
            count++;
            start -= steps;
            dfsDownWard(steps);
        }
    }
    
}
