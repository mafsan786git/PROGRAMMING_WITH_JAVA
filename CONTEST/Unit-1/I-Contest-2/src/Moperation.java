import java.util.Scanner;

public class Moperation {
    void Operation(int lenOfA,int lenOfB,int m,int j){
        int len = Math.abs(lenOfA-lenOfB);
        int OperNeed = lenOfA*2+len;
        if(OperNeed == m)
            System.out.println("Yes");
        else if(OperNeed < m)
        {
            m = m-OperNeed;
//            int rem = m/2;

            if((j + 1) * 2 <= m || m % 2 == 0)
                System.out.println("Yes");
            else
                System.out.println("No");
        }else
            System.out.println("No");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (0 < t--){
            sc.nextLine();
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            int m = sc.nextInt();
            int j=-1;
            for (int i = 0; i < str1.length() && i<str2.length(); i++) {
                if(str1.charAt(i) != str2.charAt(i))
                    break;
                j++;
            }
            int lenOfB = str2.length()-j-1;
            int lenOfA = str1.length()-j-1;
            Moperation Obj = new Moperation();
            if(lenOfA < lenOfB)
            {
                Obj.Operation(lenOfA,lenOfB,m,j);
            }else if(lenOfA == lenOfB){
                Obj.Operation(lenOfA,lenOfB,m,j);
            }else
            {
                Obj.Operation(lenOfB,lenOfA,m,j);
            }
        }
    }
}
