import java.util.*;
public class FixedCombination {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        Combination(n,1,k,new ArrayList<Integer>(),output);
        for(ArrayList<Integer> arr : output){
            for(Integer val : arr)
                System.out.print(val + " ");
            System.out.println();
        }
        sc.close();
    }


    static void Combination(int n,int temp,int k,ArrayList<Integer> ans,ArrayList<ArrayList<Integer>> output){
        if(ans.size() == k)
        {
            output.add(new ArrayList<>(ans));
            return ;
        }
        if(temp > n)
            return ;

        ans.add(temp);
        Combination(n, temp+1, k, ans, output);
        ans.remove(ans.size()-1);
        Combination(n, temp+1, k, ans, output);
    }
    
}
