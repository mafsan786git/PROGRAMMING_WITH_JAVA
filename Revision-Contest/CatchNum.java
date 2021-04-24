import java.util.*;
public class CatchNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t =sc.nextInt();
        while(t-- > 0){
            int row = sc.nextInt();
            int col = sc.nextInt();
            long ans = 0;
            if(row == 1 && col == 1){
                System.out.println(1);
                continue;
            }
            if(row%2 == 0)
            {
                if(row >= col)
                {
                    ans = row*row-col+1;
                }else{
                    if(col%2 == 0)
                        ans = (col-1)*(col-1)+row;
                    else
                        ans = col*col - row+1;
                }
            }else{
                if(row >= col)
                {
                    ans = (row-1)*(row-1) + col;
                }else{
                    if(col%2 == 0)
                        ans = (col-1)*(col-1)+row;
                    else
                        ans = col*col - row+1;
                }
            }
            System.out.println(ans);
        }
    }
}
