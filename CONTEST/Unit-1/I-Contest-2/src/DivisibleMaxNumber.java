import java.util.Arrays;
import java.util.Scanner;

public class DivisibleMaxNumber {
    void Print(int[] arr)
    {
        for (int i = 9; i >=0 ; i--) {
            if(arr[i] > 0)
                for (int j = 0; j < arr[i]; j++)
                    System.out.print(i);
        }
        System.out.println();
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(0 < t--){
            String str = sc.nextLine();
            long sum = 0;
            int[] arr = new int[10];
            for (int i = 0; i < str.length(); i++) {
                sum +=str.charAt(i) - '0';
                arr[str.charAt(i)-'0']++;
            }
            DivisibleMaxNumber Obj = new DivisibleMaxNumber();

            if(arr[0] != 0)
            {
                if(sum == 0)
                    System.out.println(0);
                else if (sum%3 == 0)
                {
                    Obj.Print(arr);
                }else
                {
                    int temp = (int) (sum%3);
                    boolean flag = false;
                    for (int i = 0; i <= 9 ; i++) {
                        if(i%3 == temp && arr[i] != 0) {
                            arr[i]--;
                            flag = true;
                            break;
                        }
                    }
                    if(flag == false)
                    {
                        temp = 3-temp;
                        int count =0;
                        for (int i = 0; i <= 9 ; i++) {
                            if(i%3 == temp && arr[i] != 0) {
                                arr[i]--;
                                count++;
                                if(arr[i] != 0) {
                                    arr[i]--;
                                    count++;
                                }
                                if(count == 2)
                                {
                                    flag = true;
                                    break;
                                }
                            }

                        }
                        if (flag)
                            Obj.Print(arr);
                        else
                            System.out.println(-1);
                    }
                    else
                        Obj.Print(arr);
                }
            }else
                System.out.println(-1);


        }
    }

}
