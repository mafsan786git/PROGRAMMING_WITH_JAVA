import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }
            int count=0;
            for (int i = 0; i < arr.length; i++) {
                if(arr[i] == 0) continue;
                int temp = arr[i];
                arr[i] = 0;
                count++;
                for (int j = i+1; j < arr.length; j++) {
                    if(arr[j] == 0) continue;
                    if(arr[j]-temp >= 1){
                        temp = arr[j];
                        arr[j] = 0;
                    }
                }
            }
            System.out.println(count);
            
        }
        sc.close();
    }
    
}
