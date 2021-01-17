import java.util.*;

class Pair{
    int x,y,z;
    Pair(int x,int y,int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
class comp implements Comparator<Pair>{
    @Override
    public int compare(Pair p1, Pair p2) {
        if(p1.x != p2.x) return p1.x - p2.x;
        if(p1.y != p2.y) return p1.y - p2.y;
        return p1.z - p2.z;
    }
}
public class ThreeSum {
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(0<t--){
            int n = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for(int i=0;i<n;i++)
                arr.add(sc.nextInt());
            ArrayList<Pair> outPut = new ArrayList<>();
            Collections.sort(arr);
            System.out.println(arr);
            for(int i=0;i<n-1;i++)
            {

                if(i != 0 && (arr.get(i).equals(arr.get(i-1))))
                    continue;
                HashMap<Integer, Boolean> mp = new HashMap<>();
                int temp = -arr.get(i);
                for (int j = i+1; j < n; j++) {

                    int x = temp-arr.get(j);
                    if(mp.containsKey(x) && !mp.get(x))
                    {
                        outPut.add(new Pair(arr.get(i),x, arr.get(j)));
                        mp.put(x,true);
                    }else
                    {
                        mp.put(arr.get(j),false);
                    }
                }
            }
            Collections.sort(outPut,new comp());

            Pair obj = outPut.get(0);
            int x = obj.x,y = obj.y,z = obj.z;
            x--;y--;z--;
            System.out.println(x + " " + y + " "+ z);
            int count=0;
            for(Pair p : outPut)
            {
                if(x != p.x || y != p.y || z != p.z)
                    count++;
                x = p.x;
                y = p.y;
                z = p.z;
            }
            System.out.println(count);
            for(Pair p : outPut)
            {
                if(x != p.x || y != p.y || z != p.z)
                    System.out.println(p.x + " " + p.y + " " +p.z);
                x = p.x;
                y = p.y;
                z = p.z;
//                System.out.println("xyz -> "+x + " " + y + " "+ z);
            }
        }
    }
}
