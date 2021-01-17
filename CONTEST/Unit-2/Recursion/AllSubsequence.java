
import java.util.ArrayList;
import java.util.Scanner;

public class AllSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        SubSequence(str,0,new ArrayList<>());
        sc.close();
    }

    //Same as Subset generator.
    static void SubSequence(String original,int index,ArrayList<Character> ans){
        for(Character ch  :ans)
            System.out.print(ch);
        if(index != 0)
            System.out.println();        
        for (int i = index; i < original.length(); i++) {
            ans.add(original.charAt(i));
            SubSequence(original, i+1, ans);
            ans.remove(ans.size()-1);
        }
    }
    
}
