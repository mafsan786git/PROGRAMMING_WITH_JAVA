
import java.io.*;
import java.util.*;
/*
PROBLEM STATEMENT--------
    It's party time in a hostel, and you are partying with your friends in the hostel's lobby. You can visualise the lobby as a 1-dimensional line (x-axis). All of you are scattered along that X-axis. Suddenly, you come to know that the warden is coming to the hostel. So, all of you want to hide inside a room. So, you will be given x-coordinates of hostel rooms as well as your current location (as x-axis coordinate). Anyone can stay at his position, move one step right from x to x + 1, or move one step left from x to x -1. Any of these moves consume1 minute. You have to find out the minimum time in which everyone in the lobby can go to any room and hide inside.
INPUT--------
    First line of input contains N whichis the total number of students present in the lobby
    Second line contains N space-separatedintegers representing current x-coordinates of students scattered in lobby.The third line also contains N spaceseparated integers representing x-coordinates of the rooms present in the lobby.
CONSTRAINTS-------
    N <= 1000000
    -1000 <= x[i] <= 1000
TIME COMPLEXITY-------
    O(n*log(n))
*/
public class Roomhiding {
    static int[] StringToInt(StringTokenizer input){
        int[] arr = new int[input.countTokens()];
        int i=0;
        while(input.hasMoreTokens())
            arr[i++] = Integer.parseInt(input.nextToken());
        return arr;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(input.nextToken());
        input = new StringTokenizer(br.readLine());
        int[] stu = new int[n];
        stu = StringToInt(input);
        input = new StringTokenizer(br.readLine());
        int[] room = new int[n];
        room = StringToInt(input);
        Arrays.sort(stu);
        Arrays.sort(room);
        int maxDis = Math.abs(stu[0]-room[0]);
        for (int i = 1; i < room.length; i++) {
            maxDis = Math.max(maxDis,  Math.abs(stu[i]-room[i]));
        }
        System.out.println(maxDis);
    }
    
}
