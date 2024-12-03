
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class NMeetingRooms {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String start1 =  br.readLine().trim();
        String[] startTime =start1.split("\\s+");

        String end1 =  br.readLine().trim();
        String[] endTime =end1.split("\\s+");
        int[] start = new int[startTime.length];
        for(int i = 0;i< start.length; i++){
            start[i] = Integer.parseInt(startTime[i]);
        }

        int[] end = new int[endTime.length];
        for(int i = 0;i< end.length; i++){
            end[i] = Integer.parseInt(endTime[i]);
        }
        System.out.println(maxMeetings(start,end));


    }

    public static int maxMeetings(int start[], int end[]) {
        // add your code here
        List<int[]> schedule = new ArrayList<>();
        for(int i = 0;i< start.length;i++){
            schedule.add(new int[]{start[i],end[i]});
        }
        Collections.sort(schedule,(s1,s2) -> s1[0] - s2[0]);
        int[] initialTiming = schedule.get(0);
        int currentEndTime = initialTiming[1];
        int count = 1;
        for(int i = 1; i < schedule.size();i++){
            int[] timing = schedule.get(i);
            if(currentEndTime < timing[0]){
                count++;
                currentEndTime = timing[1];
                continue;
            }
            if(currentEndTime > timing[1]){
                currentEndTime = timing[1];
            }
        }
        return count;
    }
}
