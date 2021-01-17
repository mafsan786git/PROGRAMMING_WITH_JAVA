package PairExample;

import java.util.*;

class Pair{
    int a,b;
    Pair(int a,int b){
        this.a = a;
        this.b = b;
    }
}
class comp implements Comparator<Pair>{
    @Override
    public int compare(Pair A, Pair B) {
        if(A.a != B.a) return A.a - B.a;
        return A.b - B.b;
    }
}
public class Solution {
    boolean Prime(int n){
        for(int j = 2;j*j<=n;j++)
        {
            if(n%j==0)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        ArrayList<Pair> output = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        Solution Obj = new Solution();
        for(int i = 2;i<=A/2;i++)
        {
            if(Obj.Prime(i) && Obj.Prime(A-i))
                output.add(new Pair(i,A-i));
        }
        Collections.sort(output,new comp());
        Pair p = output.get(0);
        System.out.println(p.a + " " + p.b);
    }
}