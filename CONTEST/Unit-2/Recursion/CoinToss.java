public class CoinToss{
    public static void main(String[] args) {
        // TossCoin(4, "");
        //Iterative
        // System.out.println("\n\nIterative---");
        // IterativeToss(4);
        // ClimbingLadder(0, 5, "");
        StringPermutation("123", "",0);
        // MazePath(2, 0, 0, "");
        // System.out.println(count);
        // ValidPair("", 3,0,0);
    }

    public static void TossCoin(int n,String ans){
        if(n == 0)
        {
            System.out.println(ans);
            return ;
        }
        TossCoin(n-1, ans + "H ");
        TossCoin(n-1, ans + "T ");
    }
    public static void IterativeToss(int n){
        System.out.println("Inside iteartive  ...");
        for (int mask = 0; mask < (1 << n); mask++) {
            String ans = "";
            for (int i = 0; i < n; i++) {
                if((mask & (1 << i)) > 0)
                    ans = " T" + ans;
                else
                    ans = " H" + ans;    
            }
            System.out.println(ans);
            
        }
    }
    public static void ClimbingLadder(int curr,int n,String ans){

        if(curr == n)
            System.out.println(ans);
        if(curr > n)
            return ;
        ClimbingLadder(curr+1, n, ans + "1");
        ClimbingLadder(curr+2, n, ans + "2");
        ClimbingLadder(curr+3, n, ans + "3");
    }

    public static void StringPermutation(String main,String ans,int index){
        
        if(main.length() == index)
        {
            System.out.println(ans);
            // System.out.println(main);
            return ;
        }
        // if(i == main.length())
        //     return ;
        for (int i = index; i < main.length(); i++) { 
            //String sq = main.substring(0,i) + main.substring(i+1);
            String str =  swap(main,i,index);
            StringPermutation(str, ans + main.charAt(i),index+1);
            str = swap(str, i, index);
            // StringPermutation(main, ans, index);
        }
    }

    public static String swap(String main,int start,int end){
        StringBuilder sb = new StringBuilder(main);
        sb.setCharAt(start,main.charAt(end));
        sb.setCharAt(end, main.charAt(start));
        return sb.toString();
    }

    //MAZE PATH NUMBER OF WAYS-------
    static int count = 0;
    public static void MazePath(int n,int currow,int curcol,String str){
        if(currow == n && curcol == n)
        {
            System.out.println(str);
            count++;
            return ;
        }
        if(currow > n || curcol > n)
            return ; 
        MazePath(n, currow, curcol+1, str + "H");//Horizontal
        MazePath(n, currow+1, curcol, str + "V");//Vertical
    }


    public static void ValidPair(String ans,int n,int open,int close){

        if(open == n && close == n)
        {
            System.out.println(ans);
            return ;
        }
        if(open > n || close > n)
            return;
        if(close > open)
            return ;
        ValidPair(ans + "(", n,open+1,close);
        ValidPair(ans + ")", n,open,close+1);
    }
}