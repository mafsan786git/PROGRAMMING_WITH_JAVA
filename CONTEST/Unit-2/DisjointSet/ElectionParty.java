import java.util.Arrays;
import java.util.Scanner;
/**
 * 
 * wrong solution try to fix it
 */
public class ElectionParty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] arr = new int[n+1];
        int[] partySize = new int[n+1];
        for (int i = 1; i < partySize.length; i++) {
            partySize[i] = 1;
            arr[i] = i;
        }
        int minSize = 1;
        int maxSize = 1;
        while(q-- > 0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            unionSecondOptimise(arr, a, b, partySize);
            minSize = Math.min(minSize, Math.min(partySize[a], partySize[b]));
            maxSize = Math.max(maxSize, Math.max(partySize[a], partySize[b]));
            // System.out.println(Arrays.toString(partySize));
            System.out.println(Math.abs(minSize-maxSize));
            System.out.println(Arrays.toString(arr));
            
        }
        sc.close();
    }
    private static void unionSecondOptimise(int[] arr,int first ,int second,int[] partySize){
        int headFirst = headFind(arr,first);
        int headSecond = headFind(arr,second);
        if(headFirst != headSecond){
            arr[headSecond] = headFirst;

            int temp = partySize[headFirst];
            partySize[headFirst] += partySize[headSecond];
            partySize[headSecond] += temp;
        }
    }
    private static int headFind(int[] arr,int node) {
        if(node == arr[node])
            return node;
        return arr[node] = headFind(arr, arr[node]);
    }
    
}
