
import java.util.*;

public class kthLargest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){

            int n = sc.nextInt();
            int k = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                arr.add(sc.nextInt());
            }
            for (int i = n/2; i>=0; i--){
                heapify(arr,i);
            }
            // System.out.println(arr);
            while(k-- > 1)
                popMaximum(arr);
            System.out.println(arr.get(0));

        }
        sc.close();
    }
    private static void popMaximum(ArrayList<Integer> arr){
        arr.set(0,arr.get(arr.size()-1));
        arr.remove(arr.size()-1);
        heapify(arr, 0);
    }

    private static void heapify(ArrayList<Integer> arr, int i) {
        int left = 2*i+1;
        int right = 2*i+2;
        int largest = i;
        if(left < arr.size() && arr.get(largest) < arr.get(left))
            largest = left;
        
        if(right < arr.size() && arr.get(largest) < arr.get(right))
            largest = right;


        if(largest != i){

            int temp = arr.get(i);
            arr.set(i,arr.get(largest));
            arr.set(largest, temp);
            heapify(arr, largest);
        }
    }
    
}
