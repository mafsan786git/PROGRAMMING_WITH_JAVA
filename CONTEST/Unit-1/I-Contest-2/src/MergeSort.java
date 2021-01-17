import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(0< t--){
            int n = sc.nextInt();
            int m = sc.nextInt();
            ArrayList<Long> first = new ArrayList<>();
            ArrayList<Long> second = new ArrayList<>();
            ArrayList<Long> result = new ArrayList<>();
            for (int i = 0; i <n ; i++)
                first.add(sc.nextLong());
            for (int i = 0; i < m; i++)
                second.add(sc.nextLong());
            Collections.sort(first);
            Collections.sort(second);
            int i =0,j=0;
            System.out.println(m+n);
            while( i < n && j < m)
            {
                if(first.get(i) <= second.get(j))
                {
                    result.add(first.get(i++));
                }else
                {
                    result.add(second.get(j++));
                }
            }
            while(i < n)
                result.add(first.get(i++));

            while(j < m)
                result.add(second.get(j++));
            for(Long ans : result)
                System.out.print(ans + " ");
            System.out.println();
        }
    }
}
