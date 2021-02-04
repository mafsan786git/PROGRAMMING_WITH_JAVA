import java.util.Scanner;

public class Flower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] totalInBouquet = new int[3];
        for(int i=0;i<3;i++)
            totalInBouquet[i] = sc.nextInt();
        int[] available = new int[3];
        for(int i=0;i<3;i++)
            available[i] = sc.nextInt();
        // long money = sc.nextLong();
        int[] costPer = new int[3];
        for(int i=0;i<3;i++)
            costPer[i] = sc.nextInt();
        int[] curAvailable = new int[3];
        for (int i = 0; i < available.length; i++) {
            if(totalInBouquet[i]!=0){
                curAvailable[i] = available[i]%totalInBouquet[i];
            }else
                curAvailable[i] = available[i];
        }
        int minIndex = 0;
        for (int i = 1; i < curAvailable.length; i++) {
            if(curAvailable[minIndex]>curAvailable[i])
                minIndex = i;
        }
        sc.close();
        
        
    }
}
