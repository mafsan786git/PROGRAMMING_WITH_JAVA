import java.util.*;
public class ProtonElectron implements Runnable {
    private static int ele = 0;
    private static int pro = 0;
    public static void main(String[] args){
        new Thread(null, new ProtonElectron(), "whatever", 1<<26).start();
    }

    public void run() {
       // Do whatever you want in this function instead of main
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] arr = new char[n][m];
        sc.nextLine();
        for (int i = 0; i < arr.length; i++) {
            String input = sc.nextLine();
            arr[i] = input.toCharArray();
        }
        int proton = 0;
        int electron = 0;
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] != '#'){
                    pro = 0;ele = 0;
                    countElecProInSameComponent(arr, i, j);
                    if(pro >= ele)
                        proton += pro;
                    else
                        electron += ele;
                }
            }
        }
        System.out.println(electron + " " + proton);
        sc.close();
    }

 
    private static void countElecProInSameComponent(char[][] arr,int row,int col){
        if(row < 0 || col < 0 || row == arr.length || col == arr[0].length)
            return ;

        if(arr[row][col] == '#')
            return ;

        if(arr[row][col] == 'E') ele++;
        if(arr[row][col] == 'P') pro++;
        arr[row][col] = '#';
        countElecProInSameComponent(arr, row+1, col);
        countElecProInSameComponent(arr, row, col+1);
        countElecProInSameComponent(arr, row-1, col);
        countElecProInSameComponent(arr, row, col-1);
    }

}
    
