import java.io.*;
import java.util.*;
public class ProtonElectron implements Runnable {
    private static int ele = 0;
    private static int pro = 0;
    public static void main(String[] args){
        new Thread(null, new ProtonElectron(), "whatever", 1<<26).start();
    }

    public void run() {
       // Do whatever you want in this function instead of main
    }
}
    

