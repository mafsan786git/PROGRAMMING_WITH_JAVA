import java.io.*;
import java.util.*;

public class Marathon {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(input.nextToken());
        int[][] arr = new int[t][2];
        int i=0;
        while(i<t){
            input = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(input.nextToken());
            arr[i][1] = Integer.parseInt(input.nextToken());
            i++;
        }
        int index = 0;
        int energy = 0;
        for (int j = 0; j < arr.length; j++) {
            energy += arr[j][0];
            if(energy < arr[j][1]){
                energy  = 0;
                index = j+1;
            }else
                energy -= arr[j][1];
        }

        for (int j = 0; j < index; j++) {
            energy += arr[j][0];
            if(energy < arr[j][1]){
                energy  = 0;
                index = -1;
                break;
            }else
                energy -= arr[j][1];
        }
        if(index == -1)
            System.out.println("No starting points");
        else
            System.out.println(index);
    }

    
}
