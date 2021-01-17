import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MukeshSuresh {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- != 0)
        {
            int n = sc.nextInt();
            sc.nextLine();
            String[] str = new String[n];
            for (int i = 0; i < n; i++) {
                str[i] = sc.nextLine();
            }
            int mukesh =0,suresh = 0;
            ArrayList<Integer> mu = new ArrayList<Integer>();
            ArrayList<Integer> su = new ArrayList<Integer>();
            for(String word:str)
            {
                String s[] = word.split(" ");
                if(s[0].equals("Mukesh")) {
                    mu.add(Integer.parseInt(s[1]));
                    mukesh = mukesh + Integer.parseInt(s[1]);
                } else {
                    su.add(Integer.parseInt(s[1]));
                    suresh = suresh + Integer.parseInt(s[1]);
                }
            }
            if(mukesh != suresh)
                System.out.println(mukesh > suresh ?  "Mukesh Wins" : "Suresh Wins");
            else
            {
                int i=0;
                boolean flag = true;
                while(i<mu.size() && i<su.size())
                {
                    if(mu.get(i) > su.get(i))
                    {
                        System.out.println("Mukesh Wins");
                        flag = false;
                        break;
                    }else if (mu.get(i) < su.get(i))
                    {
                        System.out.println("Suresh Wins");
                        flag = false;
                        break;
                    }
                    i++;
                }
                if (mu.size() == su.size() && flag)
                {
                    String s[] = str[n-1].split(" ");
                    System.out.println(s[0]+" Wins");
                }else if (flag){
                    if(i == mu.size())
                        System.out.println("Suresh Wins");
                    else
                        System.out.println("Mukesh Wins");
                }

            }
        }

    }
}
